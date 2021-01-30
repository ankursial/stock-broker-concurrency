package com.ankur.stockbroker.controllers;

import com.ankur.stockbroker.exception.CustomerNotFoundException;
import com.ankur.stockbroker.exception.OrderNotFoundException;
import com.ankur.stockbroker.exception.StockNotFoundException;
import com.ankur.stockbroker.models.Customer;
import com.ankur.stockbroker.models.Stock;
import com.ankur.stockbroker.models.StockOrder;
import com.ankur.stockbroker.services.ICustomerService;
import com.ankur.stockbroker.services.IOrderService;
import com.ankur.stockbroker.services.IStockService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/customers/{customerId}/orders")
public class OrderController {

  @Autowired
  ICustomerService customerService;
  @Autowired
  IOrderService orderService;
  @Autowired
  IStockService stockService;

  private int MAX_TRIALS_BEFORE_FAIL = 10;

  @PostMapping
  public StockOrder addStockOrder(@PathVariable("customerId") @Min(1) long customerId, @RequestParam String stockSymbol,
      @Valid @RequestBody StockOrder order) {
    Customer customer = getCustomerById(customerId);
    Stock stock = getStockBySymbol(stockSymbol);
    order.setStock(stock);

    for (int ndx = 0; ndx < MAX_TRIALS_BEFORE_FAIL; ndx++) {
      try {
        return orderService.requestOrder(customer, order);
      } catch (ObjectOptimisticLockingFailureException e) {
        log.warn("ObjectOptimisticLockingFailureException...");
      }
    }

    //last try else exception will be thrown
    return orderService.requestOrder(customer, order);
  }

  @GetMapping
  public List<StockOrder> getStockOrders(@PathVariable("customerId") @Min(1) long customerId) {
    Customer customer = getCustomerById(customerId);
    return customer.getStockOrders();
  }

  @GetMapping(value = "/{orderId}")
  public StockOrder getStockOrders(@PathVariable("customerId") @Min(1) long customerId,
      @PathVariable("orderId") @Min(1) long orderId) {
    Customer customer = getCustomerById(customerId);
    StockOrder stockOrder = getStockOrderById(orderId);
    if (!stockOrder.getCustomer().equals(customer)) {
      throw new OrderNotFoundException(
          "Order with " + orderId + " is Not Found for customer with " + customerId);
    }
    return stockOrder;
  }

  private StockOrder getStockOrderById(long id) {
    return orderService.getOrderById(id).orElseThrow(() -> new OrderNotFoundException(
        "Order with " + id + " is Not Found!"));
  }

  private Customer getCustomerById(long id) {
    return customerService.findById(id).orElseThrow(() -> new CustomerNotFoundException(
        "Customer with " + id + " is Not Found!"));
  }

  private Stock getStockBySymbol(String symbol) {
    return stockService.findBySymbol(symbol).orElseThrow(() -> new StockNotFoundException(
        "Stock " + symbol + " is Not Found!"));
  }
}


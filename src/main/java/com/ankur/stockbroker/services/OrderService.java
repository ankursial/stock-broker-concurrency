package com.ankur.stockbroker.services;

import com.ankur.stockbroker.exception.BalanceNotAvailableException;
import com.ankur.stockbroker.exception.RequestedPriceNotAvailableException;
import com.ankur.stockbroker.exception.StockInventoryNotFoundException;
import com.ankur.stockbroker.exception.StockQuantityNotAvailableException;
import com.ankur.stockbroker.models.Customer;
import com.ankur.stockbroker.models.OrderStatus;
import com.ankur.stockbroker.models.OrderType;
import com.ankur.stockbroker.models.StockInventory;
import com.ankur.stockbroker.models.StockOrder;
import com.ankur.stockbroker.repositories.CustomerRepository;
import com.ankur.stockbroker.repositories.OrderRepository;
import com.ankur.stockbroker.repositories.StockInventoryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

  @Autowired
  OrderRepository orderRepository;
  @Autowired
  CustomerRepository customerRepository;
  @Autowired
  StockInventoryRepository stockInventoryRepository;

  @Override
  public Optional<StockOrder> getOrderById(long id) {
    return orderRepository.findById(id);
  }

  @Override
  public StockOrder requestOrder(Customer customer, StockOrder order) {
    order.setStatus(OrderStatus.CREATED);
    order.setCustomer(customer);
    customer.getStockOrders().add(order);
    StockInventory stockInventory = stockInventoryRepository.findByStock(order.getStock())
        .orElseThrow(() -> new StockInventoryNotFoundException(
            "Stock Inventory not found for stock " + order.getStock().getSymbol()));
    //check if quantity exists
    if (order.getQuantity() > stockInventory.getAvailableQuantity()) {
      order.setStatus(OrderStatus.QUANTITY_NOT_AVAILABLE);
      throw new StockQuantityNotAvailableException("Quantity not available");
    }

    //check for requested price
    if (!order.getOrderType().equals(OrderType.MARKET) && order.getRequestedPrice() < stockInventory.getPrice()) {
      order.setStatus(OrderStatus.REQUESTED_PRICE_NOT_AVAILABLE);
      throw new RequestedPriceNotAvailableException("Requested price not available");
    }

    float requiredBalance = order.getQuantity() * stockInventory.getPrice();
    float balanceAfterTransaction = customer.getBalance() - requiredBalance;
    //check if user has balance
    if (balanceAfterTransaction < 0) {
      order.setStatus(OrderStatus.BALANCE_NOT_AVAILABLE);
      throw new BalanceNotAvailableException("Balance not available");
    }

    stockInventory.setAvailableQuantity(stockInventory.getAvailableQuantity() - order.getQuantity());

//    try {
//      Thread.sleep(10);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    //transaction approved
    customer.setBalance(balanceAfterTransaction);
    order.setAllottedPrice(stockInventory.getPrice());
    customerRepository.save(customer);
    stockInventoryRepository.save(stockInventory);
    order.setStatus(OrderStatus.COMPLETED);
    return orderRepository.save(order);
  }
}

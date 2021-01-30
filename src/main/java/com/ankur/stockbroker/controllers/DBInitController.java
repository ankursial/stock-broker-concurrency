package com.ankur.stockbroker.controllers;

import com.ankur.stockbroker.models.Customer;
import com.ankur.stockbroker.models.Stock;
import com.ankur.stockbroker.models.StockInventory;
import com.ankur.stockbroker.repositories.AccountRepository;
import com.ankur.stockbroker.repositories.CustomerRepository;
import com.ankur.stockbroker.repositories.OrderRepository;
import com.ankur.stockbroker.repositories.StockInventoryRepository;
import com.ankur.stockbroker.repositories.StockOrderRepository;
import com.ankur.stockbroker.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/db-init")
public class DBInitController {

  @Autowired
  StockOrderRepository stockOrderRepository;
  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private StockInventoryRepository stockInventoryRepository;
  @Autowired
  private StockRepository stockRepository;

  @PostMapping
  public String initializeDb() {
    orderRepository.deleteAll();
    customerRepository.deleteAll();
    stockOrderRepository.deleteAll();
    accountRepository.deleteAll();
    stockInventoryRepository.deleteAll();
    stockRepository.deleteAll();

    Stock relianceStock = new Stock("Reliance Industries Limited", "RELIANCE");
    Stock aaStock = new Stock("AA Industries Ltd", "AA");
    stockRepository.save(relianceStock);
    stockRepository.save(aaStock);

    StockInventory relianceStockInventory = new StockInventory(relianceStock, 1000, 1000, 2000);
    StockInventory aaStockInventory = new StockInventory(aaStock, 3000, 3000, 4000);
    stockInventoryRepository.save(relianceStockInventory);
    stockInventoryRepository.save(aaStockInventory);

    int customersToBeCreated = 5;
    for (int ndx = 1; ndx <= customersToBeCreated; ndx++) {
      Customer customer = Customer.builder()
          .name("Customer " + ndx)
          .email("customer" + ndx + "@email.com")
          .balance(1000000)
          .build();
      customerRepository.save(customer);
    }

    return "success";
  }

}

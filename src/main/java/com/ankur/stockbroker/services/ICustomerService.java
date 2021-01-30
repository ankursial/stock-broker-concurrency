package com.ankur.stockbroker.services;

import com.ankur.stockbroker.models.Customer;
import java.util.List;
import java.util.Optional;

public interface ICustomerService {

  List<Customer> getAllCustomers();

  Optional<Customer> findById(long id);

  void deleteById(long id);

  Customer save(Customer customer);
}

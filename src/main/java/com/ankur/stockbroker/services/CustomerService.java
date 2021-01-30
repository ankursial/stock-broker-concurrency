package com.ankur.stockbroker.services;

import com.ankur.stockbroker.models.Customer;
import com.ankur.stockbroker.repositories.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Override
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Optional<Customer> findById(long id) {
    return customerRepository.findById(id);
  }

  @Override
  public void deleteById(long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }
}

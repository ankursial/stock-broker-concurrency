package com.ankur.stockbroker.controllers;

import com.ankur.stockbroker.exception.CustomerNotFoundException;
import com.ankur.stockbroker.models.Customer;
import com.ankur.stockbroker.services.ICustomerService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  @Autowired
  private ICustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping(value = "/{id}")
  public Customer getCustomerDetails(@PathVariable("id") @Min(1) long id) {
    Customer customer = getCustomerById(id);
    return customer;
  }

  @PostMapping
  public Customer addCustomer(@Valid @RequestBody Customer customer) {
    return customerService.save(customer);
  }

  @PutMapping(value = "/{id}")
  public Customer updateCustomer(@PathVariable("id") @Min(1) long id, @Valid @RequestBody Customer newCustomer) {
    Customer customer = getCustomerById(id);
    customer.setName(newCustomer.getName());
    customer.setEmail(newCustomer.getEmail());
    customer.setBalance(newCustomer.getBalance());
    return customerService.save(customer);
  }

  @DeleteMapping(value = "/{id}")
  public String deleteCustomer(@PathVariable("id") @Min(1) long id) {
    Customer customer = getCustomerById(id);
    customerService.deleteById(customer.getId());
    return "Customer with ID :" + id + " is deleted";
  }

  private Customer getCustomerById(@PathVariable("id") @Min(1) long id) {
    return customerService.findById(id).orElseThrow(() -> new CustomerNotFoundException(
        "Customer with " + id + " is Not Found!"));
  }
}

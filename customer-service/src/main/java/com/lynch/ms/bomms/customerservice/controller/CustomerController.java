package com.lynch.ms.bomms.customerservice.controller;

import com.lynch.ms.bomms.customerservice.model.Customer;
import com.lynch.ms.bomms.customerservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
@RestController
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

  @GetMapping("/customers")
  public List<Customer> getAllCustomers(){
    return customerService.getAllCustomers();
  }

  @GetMapping("/customers/{id}")
  public Optional<Customer> getCustomer(@PathVariable Long id){ return customerService.getCustomer(id); }

  @PostMapping("/customers")
  public void addCustomer(@RequestBody Customer customer){
    customerService.addCustomer(customer);
  }

  @PutMapping("/customers")
  public void editCustomer(@RequestBody Customer customer){
    customerService.editCustomer(customer);
  }

  @DeleteMapping("/customers/{id}")
  public void deleteCustomer(@PathVariable Long id){
    customerService.deleteCustomer(id);
  }

}

package com.lynch.ms.bomms.customerservice.service;

import com.lynch.ms.bomms.customerservice.model.Customer;
import com.lynch.ms.bomms.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  public void addCustomer(Customer customer){
    customerRepository.save(customer);
  }

  public void editCustomer(Customer customer){
    customerRepository.save(customer);
  }

  public void deleteCustomer(Long id){
    customerRepository.deleteById(id);
  }

  public Optional<Customer> getCustomer(Long id){
    return customerRepository.findById(id);
  }

  public Optional<Customer> getCustomerByCustId(String custId){
    return customerRepository.getCustomerByCustId(custId);
  }

  public List<Customer> getAllCustomers(){
    return customerRepository.findAll();
  }
}

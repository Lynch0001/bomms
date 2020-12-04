package com.lynch.ms.bomms.customerservice.repository;

import com.lynch.ms.bomms.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long>{

  Optional<Customer> getCustomerByCustId(String custId);
}

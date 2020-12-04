package com.lynch.ms.bomms.customerservice.repository;

import com.lynch.ms.bomms.customerservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}

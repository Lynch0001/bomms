package com.lynch.ms.bomms.customerservice.repository;

import com.lynch.ms.bomms.customerservice.model.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
}

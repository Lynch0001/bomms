package com.lynch.ms.bomms.storeservice.repository;

import com.lynch.ms.bomms.storeservice.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository <Store, Long> {
}

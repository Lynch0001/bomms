package com.lynch.ms.bomms.storeservice.repository;

import com.lynch.ms.bomms.storeservice.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

  public List<InventoryItem> getInventoryItemsByStoreStoreCode(String storeCode);

}

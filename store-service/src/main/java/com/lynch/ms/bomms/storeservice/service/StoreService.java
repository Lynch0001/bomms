package com.lynch.ms.bomms.storeservice.service;

import com.lynch.ms.bomms.storeservice.model.InventoryItem;
import com.lynch.ms.bomms.storeservice.model.Store;
import com.lynch.ms.bomms.storeservice.repository.InventoryItemRepository;
import com.lynch.ms.bomms.storeservice.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StoreService {

  @Autowired
  private StoreRepository storeRepository;
  
  @Autowired
  private InventoryItemRepository inventoryItemRepository;

  public List<Store> getAllStores(){
    return storeRepository.findAll();
  }

  public Optional<Store> getStore(Long id){
    return storeRepository.findById(id);
  }

  public void createStore(Store store){
    storeRepository.save(store);
  }

  public void editStore(Store store){
    storeRepository.save(store);
  }

  public void deleteStore(Long id){
    storeRepository.deleteById(id);
  }

  public List<InventoryItem> getAllInventoryItems(){

    List<InventoryItem> items = inventoryItemRepository.findAll();
    System.out.println("Store Service - Find All Inventory Items: " + items);
    return inventoryItemRepository.findAll();
  }

  public List<InventoryItem> getInventoryItemsByStore(String storeCode) {
    return inventoryItemRepository.getInventoryItemsByStoreStoreCode(storeCode);
  }

  public Optional<InventoryItem> getInventoryItem(Long id){
    return inventoryItemRepository.findById(id);
  }

  public void createInventoryItem(InventoryItem inventoryItem){
    inventoryItemRepository.save(inventoryItem);
  }

  public void editInventoryItem(InventoryItem inventoryItem){
    inventoryItemRepository.save(inventoryItem);
  }

  public void deleteInventoryItem(Long id){
    inventoryItemRepository.deleteById(id);
  }
  
  
  
}

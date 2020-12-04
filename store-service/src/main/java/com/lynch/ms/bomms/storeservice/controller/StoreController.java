package com.lynch.ms.bomms.storeservice.controller;

import com.lynch.ms.bomms.storeservice.model.InventoryItem;
import com.lynch.ms.bomms.storeservice.model.Store;
import com.lynch.ms.bomms.storeservice.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@RestController
@RequestMapping("/api")
public class StoreController {

  private static final Logger log = LoggerFactory.getLogger(StoreController.class);

  @Autowired
  private StoreService storeService;

  @GetMapping("/stores/inventory")
  public Map<String, Integer> getAllStoresInventory(){
    List<InventoryItem> inventoryItemList = storeService.getAllInventoryItems();
    // Return map of inventory with quantities for each book (isbn13)
    return inventoryItemList.stream().collect(Collectors.groupingBy(InventoryItem::getIsbn13, Collectors.summingInt(InventoryItem::getQuantity)));
  }

  @GetMapping("/stores/{storeCode}/inventory")
  public Map<String, Integer> getStoresInventory(@PathVariable String storeCode){
    List<InventoryItem> inventoryItemList = storeService.getInventoryItemsByStore(storeCode);
    // Return map of store inventory with quantities for each book (isbn13)
    return inventoryItemList.stream().collect(Collectors.groupingBy(InventoryItem::getIsbn13, Collectors.summingInt(InventoryItem::getQuantity)));
  }

  @GetMapping("/stores")
  public List<Store> getAllStores(){
    return storeService.getAllStores();
  }

  @GetMapping("/stores/{id}")
  public Optional<Store> getStore(@PathVariable Long id){
    return storeService.getStore(id);
  }

  @PostMapping("/stores")
  public void createStore(@Valid @RequestBody Store store){
    storeService.createStore(store);
  }

  @PutMapping("/stores")
  public void editStore(@Valid @RequestBody Store store){
    storeService.editStore(store);
  }

  @DeleteMapping("/stores/{id}")
  public void deleteStore(@PathVariable Long id){
    storeService.deleteStore(id);
  }

  @GetMapping("/inventoryItems")
  public List<InventoryItem> getAllInventoryItems(){
    return storeService.getAllInventoryItems();
  }

  @GetMapping("/inventoryItems/{id}")
  public Optional<InventoryItem> getInventoryItem(@PathVariable Long id){
    return storeService.getInventoryItem(id);
  }

  @PostMapping("/inventoryItems")
  public void createInventoryItem(@RequestBody InventoryItem inventoryItem){
    storeService.createInventoryItem(inventoryItem);
  }

  @PutMapping("/inventoryItems")
  public void editInventoryItem(@RequestBody InventoryItem inventoryItem){
    storeService.editInventoryItem(inventoryItem);
  }

  @DeleteMapping("/inventoryItems/{id}")
  public void deleteInventoryItem(@PathVariable Long id){
    storeService.deleteInventoryItem(id);
  }
}


package com.lynch.ms.bomms.storeservice.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name="stores")
public class Store implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name="store_code")
  private String storeCode;
  @Column(name="address")
  private String streetAddress;
  @Column(name="city")
  private String city;
  @Column(name="state")
  @Size(min=2, max=2)
  @Pattern(regexp = "^[A-Z]{2}$")
  private String state;
  @Column(name="zip")
  @Size(min=5, max=10)
  @Pattern(regexp = "^\\d{5}(-{1}\\d{4})?$")
  private String zip;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
  private List<InventoryItem> storeInventory = new ArrayList<>();


  public Store(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStoreCode() {
    return storeCode;
  }

  public void setStoreCode(String storeCode) {
    this.storeCode = storeCode;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public List<InventoryItem> getStoreInventory() {
    return storeInventory;
  }

  public void setStoreInventory(List<InventoryItem> storeInventory) {
    this.storeInventory = storeInventory;
  }

  @Override
  public String toString() {
    return "Store{" +
            "id=" + id +
            "code=" + storeCode +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            '}';
  }
}

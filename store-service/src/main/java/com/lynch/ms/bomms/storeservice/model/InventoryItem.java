package com.lynch.ms.bomms.storeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "inventory_items")
public class InventoryItem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private Long id;
  @Column(name="isbn13")
  private String isbn13;
  @Column(name="quantity")
  private Integer quantity;
  @JsonIgnore
  @ManyToOne
  private Store store;

  public InventoryItem() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
  }

  @Override
  public String toString() {
    return "InventoryItem{" +
            "id=" + id +
            ", isbn13='" + isbn13 + '\'' +
            ", quantity=" + quantity +
            ", store=" + store +
            '}';
  }
}

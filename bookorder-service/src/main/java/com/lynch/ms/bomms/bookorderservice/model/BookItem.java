package com.lynch.ms.bomms.bookorderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="bookitems")
public class BookItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name="isbn")  // Use for testing
  private String isbn;

  @Column(name="price")  // Use for testing
  private Float price;

  @Column(name="quantity")
  private Integer quantity;

  @ManyToOne
  @JsonIgnore
  private BookOrder bookOrder;

  public BookItem(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "BookItem{" +
            "id=" + id +
            ", isbn='" + isbn + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            '}';
  }
}

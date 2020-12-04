package com.lynch.ms.bomms.bookorderservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="bookorders")
public class BookOrder implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  // Customer

  @Column(name="custid") // Use for testing
  private String custId;

  //  Date

  @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  @Column(name="order_date", nullable=true)
  private Date orderDate;


  // Books (Book, Quantity, Price)

  @OneToMany(targetEntity=BookItem.class,cascade = CascadeType.ALL,
          fetch = FetchType.EAGER, orphanRemoval = true)
  private Set<BookItem> bookItems;

  public BookOrder() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
  }

  public Set<BookItem> getBookItems() {
    return bookItems;
  }

  public void setBookItems(Set<BookItem> bookItems) {
    this.bookItems = bookItems;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  @Override
  public String toString() {
    return "BookOrder{" +
            "id=" + id +
            ", custId='" + custId + '\'' +
            ", orderDate=" + orderDate +
            '}';
  }
}

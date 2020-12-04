package com.lynch.ms.bomms.customerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name="street")
  @Nullable
  private String Street;
  @Column(name="city")
  @Nullable
  private String City;
  @Column(name="state")
  @Nullable
  private String State;
  @Column(name="zip")
  @Nullable
  private String Zip;

  @Column(name="is_shipping")
  private Boolean isShipping = false;

  @Column(name="is_billing")
  private Boolean isBilling = false;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name="customer_id", nullable=false)
  private Customer customer;

  public Address() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Nullable
  public String getStreet() {
    return Street;
  }

  public void setStreet(@Nullable String street) {
    Street = street;
  }

  @Nullable
  public String getCity() {
    return City;
  }

  public void setCity(@Nullable String city) {
    City = city;
  }

  @Nullable
  public String getState() {
    return State;
  }

  public void setState(@Nullable String state) {
    State = state;
  }

  @Nullable
  public String getZip() {
    return Zip;
  }

  public void setZip(@Nullable String zip) {
    Zip = zip;
  }

  public Boolean getShipping() {
    return isShipping;
  }

  public void setShipping(Boolean shipping) {
    isShipping = shipping;
  }

  public Boolean getBilling() {
    return isBilling;
  }

  public void setBilling(Boolean billing) {
    isBilling = billing;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}

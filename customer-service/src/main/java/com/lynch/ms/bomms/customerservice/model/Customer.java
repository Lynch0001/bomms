package com.lynch.ms.bomms.customerservice.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name="cust_id")
  private String custId;
  @Column(name="password")
  private String password;
  @Column(name="firstname")
  private String firstName;
  @Column(name="lastname")
  private String lastName;
  @Column(name="email")
  @Email
  private String email;
  @Column(name="phone")
  private String phone;
  @DateTimeFormat(pattern = "mm-dd-yy")
  @Column(name="birthday")
  private Date birthday;

  @OneToMany(mappedBy = "customer")
  private Set<Address> addresses;

  @OneToMany(mappedBy = "customer")
  private Set<Interest> interests;

  public Customer() {
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }

  public Set<Interest> getInterests() {
    return interests;
  }

  public void setInterests(Set<Interest> interests) {
    this.interests = interests;
  }
}

package com.lynch.ms.bomms.catalogservice.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Entity
public class CatalogItem implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String subtitle;
  private String authors;
  private String publisher;
  private String language;
  private String isbn13;
  private String pages;
  private String year;
  private String rating;
  private String desc;
  private String price;
  private String image;
  private String url;
  private Integer quantity;


  @OneToMany(mappedBy = "catalogItem")
  private List<Review> reviews = new ArrayList<Review>();

  public CatalogItem(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public void setSubtitle(String subtitle) {
    this.subtitle = subtitle;
  }

  public String getAuthors() {
    return authors;
  }

  public void setAuthors(String authors) {
    this.authors = authors;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }

  public String getPages() {
    return pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "CatalogItem{" +
            "id=" + id +
            ", isbn13='" + isbn13 + '\'' +
            ", title='" + title + '\'' +
            ", subtitle='" + subtitle + '\'' +
            ", price='" + price + '\'' +
            ", image='" + image + '\'' +
            ", url='" + url +
            '}';
  }
}

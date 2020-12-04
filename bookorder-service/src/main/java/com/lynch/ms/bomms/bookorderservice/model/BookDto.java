package com.lynch.ms.bomms.bookorderservice.model;


public class BookDto {

  private String isbn;

  private String title;

  private Float price;

  BookDto(){}

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }
}

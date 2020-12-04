package com.lynch.ms.bomms.bookservice.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="subtitle")
    private String subtitle;


    @Column(name="authors")
    private String authors;
    @Column(name="publisher")
    private String publisher;
    @Column(name="language")
    private String language;


    @Column(name="isbn13")
    private String isbn13;

    @Column(name="pages")
    private String pages;
    @Column(name="year")
    private String year;
    @Column(name="rating")
    private String rating;
    @Column(name="desc")
    private String desc;



    @Column(name="price")
    private String price;
    @Column(name="image")
    private String image;
    @Column(name="url")
    private String url;

    public Book() {
      // constructor
    }

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

  public String getIsbn13() {
    return isbn13;
  }

  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
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

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", subtitle='" + subtitle + '\'' +
            ", authors='" + authors + '\'' +
            ", publisher='" + publisher + '\'' +
            ", language='" + language + '\'' +
            ", isbn13='" + isbn13 + '\'' +
            ", pages='" + pages + '\'' +
            ", year='" + year + '\'' +
            ", rating='" + rating + '\'' +
            ", desc='" + desc + '\'' +
            ", price='" + price + '\'' +
            ", image='" + image + '\'' +
            ", url='" + url + '\'' +
            '}';
  }
}

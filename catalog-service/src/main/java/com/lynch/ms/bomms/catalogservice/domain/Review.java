package com.lynch.ms.bomms.catalogservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Review implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String isbn13;
  private String reviewer;
  // private Date reviewDate;
  @Lob
  private String reviewComment;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "fk_item")
  CatalogItem catalogItem;

  public Review() {
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

  public String getReviewer() {
    return reviewer;
  }

  public void setReviewer(String reviewer) {
    this.reviewer = reviewer;
  }

  public String getReviewComment() {
    return reviewComment;
  }

  public void setReviewComment(String reviewComment) {
    this.reviewComment = reviewComment;
  }

  public CatalogItem getCatalogItem() {
    return catalogItem;
  }

  public void setCatalogItem(CatalogItem catalogItem) {
    this.catalogItem = catalogItem;
  }

  @Override
  public String toString() {
    return "Review{" +
            "id=" + id +
            ", isbn13='" + isbn13 + '\'' +
            ", reviewer='" + reviewer + '\'' +
            ", reviewComment='" + reviewComment + '\'' +
            '}';
  }
}

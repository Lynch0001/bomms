package com.lynch.ms.bomms.reviewservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "reviews")
public class Review implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "isbn")
  private String isbn13;
  @Column(name = "reviewer")
  private String reviewer;
  // @Column(name = "date")
  // private Date reviewDate;
  @Lob
  @Column(name = "comment")
  private String reviewComment;

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

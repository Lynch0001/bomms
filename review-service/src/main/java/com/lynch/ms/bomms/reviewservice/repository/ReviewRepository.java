package com.lynch.ms.bomms.reviewservice.repository;

import com.lynch.ms.bomms.reviewservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

  public List<Review> findReviewsByIsbn13(String isbn);
}

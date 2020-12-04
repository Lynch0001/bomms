package com.lynch.ms.bomms.reviewservice.service;

import com.lynch.ms.bomms.reviewservice.model.Review;
import com.lynch.ms.bomms.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

  @Autowired
  ReviewRepository reviewRepository;

  public List<Review> getAllReviews(){
    return reviewRepository.findAll();
  }

  public List<Review> findReviewsByIsbn13(String isbn){
    return reviewRepository.findReviewsByIsbn13(isbn);
  }
}

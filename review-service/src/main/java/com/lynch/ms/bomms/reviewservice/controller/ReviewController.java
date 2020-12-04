package com.lynch.ms.bomms.reviewservice.controller;

import com.lynch.ms.bomms.reviewservice.model.Review;
import com.lynch.ms.bomms.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ReviewController {

  @Autowired
  ReviewService reviewService;

  @RequestMapping("/reviews")
  public List<Review> getAllReviews(){
    return reviewService.getAllReviews();
  }

  @RequestMapping("/reviews/{isbn13}")
  public List<Review> getReviewsByIsbn(@PathVariable String isbn13){
    return reviewService.findReviewsByIsbn13(isbn13);
  }

  }



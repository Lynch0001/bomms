package com.lynch.ms.bomms.catalogservice.controller;

import com.lynch.ms.bomms.catalogservice.domain.Book;
import com.lynch.ms.bomms.catalogservice.domain.CatalogItem;
import com.lynch.ms.bomms.catalogservice.domain.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
@RestController
public class CatalogController {

  private static final Logger log = LoggerFactory.getLogger(CatalogController.class);

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  private Environment environment;

  // private final String API_KEY = environment.getProperty("api.key.google");

  @Cacheable(value = "catalog")
  @RequestMapping("/catalog")
  public List<CatalogItem> getEnterpriseCatalog(){
    // Get inventory
    Map<String, Integer> inventory = restTemplate.getForObject("http://localhost:8025/api/stores/inventory", Map.class);  //localhost:8025
    log.debug("Retrieved inventory: {}", inventory);
    // Stream Map Entries
    Stream<Map.Entry<String, Integer>> inventoryEntries = inventory.entrySet().stream();
    // Get Book and Review Details for ISBNs in Inventory
    List<CatalogItem> catalog = inventoryEntries
            .map(entry -> {
              String k_isbn = entry.getKey();
              Integer v_quantity = entry.getValue();
              CatalogItem catalogItem = generateCatalogItem(getBookDetails(k_isbn), getReviewDetails(k_isbn), v_quantity);
              return catalogItem;
            })
            .collect(Collectors.toList());

    log.debug("Merged catalog: {}", catalog);
    // Return catalog
    return catalog;
  }

  public Book getBookDetails(String isbn13){
    Book response = restTemplate.getForObject("http://localhost:8027/api/books/" + isbn13, Book.class);  //localhost:8027
    log.debug("Retrieved book with ISBN {}: {}", isbn13, response);
    return response;
  }

  public List<Review> getReviewDetails(String isbn13){
    Review[] response = restTemplate.getForObject("http://localhost:8024/api/reviews/" + isbn13, Review[].class);  //localhost:8024
    log.debug("Retrieved review for ISBN {}: {}", isbn13, response);
    return Arrays.asList(response.clone());
  }

  public CatalogItem generateCatalogItem(Book book, List<Review> reviews, Integer quantity){
    CatalogItem catalogItem = new CatalogItem();
    catalogItem.setId(book.getId());
    catalogItem.setIsbn13(book.getIsbn13());
    catalogItem.setTitle(book.getTitle());
    catalogItem.setSubtitle(book.getSubtitle());
    catalogItem.setAuthors(book.getAuthors());
    catalogItem.setPublisher(book.getPublisher());
    catalogItem.setLanguage(book.getLanguage());
    catalogItem.setPages(book.getPages());
    catalogItem.setYear(book.getYear());
    catalogItem.setRating(book.getRating());
    catalogItem.setDesc(book.getDesc());
    catalogItem.setPrice(book.getPrice());
    catalogItem.setImage(book.getImage());
    catalogItem.setUrl(book.getUrl());
    catalogItem.setReviews(reviews);
    catalogItem.setQuantity(quantity);
    return catalogItem;
  }
}

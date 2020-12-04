package com.lynch.ms.bomms.bookservice.controller;

import com.lynch.ms.bomms.bookservice.model.Book;
import com.lynch.ms.bomms.bookservice.model.ItBookStoreBookResponse;
import com.lynch.ms.bomms.bookservice.model.ItBookStoreListResponse;
import com.lynch.ms.bomms.bookservice.service.BookService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private RestTemplate restTemplate;

  private static final Logger log = LoggerFactory.getLogger(BookController.class);

  @GetMapping("/books")
  public List<Book> getAllBooks() {
    log.debug("Entered GetAllBooks Method");
    String itBookStoreUrl = "https://api.itbook.store/1.0/search/all";
    HttpHeaders headers = new HttpHeaders();
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> param = new HttpEntity<String>("parameters", headers);
    ResponseEntity<ItBookStoreListResponse> response = restTemplate.exchange(itBookStoreUrl, HttpMethod.GET,param, ItBookStoreListResponse.class);
    log.debug("Received Response Code: {}", response.getStatusCode());
    log.debug("Received Response Type: {}", response.getBody().getBooks().getClass());
    return response.getBody().getBooks();
  }

  @GetMapping("/books/{isbn}")
  public ItBookStoreBookResponse getBookByIsbn(@PathVariable Long isbn){
    log.debug("Entered GetBooksByIsbn Method");
    String itBookStoreUrl = "https://api.itbook.store/1.0/books/";
    HttpHeaders headers = new HttpHeaders();
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> param = new HttpEntity<String>("parameters", headers);
    log.debug("Submitting request to External ITBook API");
    ResponseEntity<ItBookStoreBookResponse> response = restTemplate.exchange(itBookStoreUrl + isbn, HttpMethod.GET,param, ItBookStoreBookResponse.class);
    log.debug("Received Response Code: {}", response.getStatusCode());
    log.debug("Received Response Type: {}", response.getBody());
    return response.getBody();
  }

  @GetMapping("/books/search/{search}")
  public List<Book> getBooksBySearchInput(@PathVariable String search){
    log.debug("Entered GetBooksByTag Method");
    String itBookStoreUrl = "https://api.itbook.store/1.0/search/";
    HttpHeaders headers = new HttpHeaders();
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> param = new HttpEntity<String>("parameters", headers);
    log.debug("Submitting request to External ITBook API");
    ResponseEntity<ItBookStoreListResponse> response = restTemplate.exchange(itBookStoreUrl + search, HttpMethod.GET,param, ItBookStoreListResponse.class);
    log.debug("Received Response Code: {}", response.getStatusCode());
    log.debug("Received Response Type: {}", response.getBody().getBooks().getClass());
    return response.getBody().getBooks().stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
  }

  @GetMapping("/books/tag/{tag}")
  public List<Book> getBooksByTag(@PathVariable String tag){
    log.debug("Entered GetBooksByTag Method");
    String itBookStoreUrl = "https://api.itbook.store/1.0/search/";
    HttpHeaders headers = new HttpHeaders();
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> param = new HttpEntity<String>("parameters", headers);
    log.debug("Submitting request to External ITBook API");
    ResponseEntity<ItBookStoreListResponse> response = restTemplate.exchange(itBookStoreUrl + tag, HttpMethod.GET,param, ItBookStoreListResponse.class);
    log.debug("Received Response Code: {}", response.getStatusCode());
    log.debug("Received Response Type: {}", response.getBody().getBooks().getClass());
    return response.getBody().getBooks().stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
  }

  @RequestMapping("/tags")
  public Map<String,String> getBookTags() throws IOException {
    String url = "https://itbook.store/books";
    Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a");
    return links.stream()
            .filter(element -> element.attr("href").startsWith("/books/") && element.hasAttr("title") && element.attr("title").contains(" Books"))
            .collect(Collectors.toMap(
                    hreftag -> hreftag.attr("href").substring(7),
                    tag -> tag.attr("title").replace(" Books","")
            ));
  }

  @PostMapping("/books")
  public void addBook(@RequestBody Book book){
    bookService.addBook(book);
  }

  @PutMapping("/books")
  public void editBook(@RequestBody Book book){
    bookService.editBook(book);
  }

  @DeleteMapping("/books/{id}")
  public void deleteBook(@PathVariable Long id){
    bookService.deleteBook(id);
  }

}

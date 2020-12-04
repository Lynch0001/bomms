package com.lynch.ms.bomms.bookorderservice.controller;

import com.lynch.ms.bomms.bookorderservice.model.BookOrder;
import com.lynch.ms.bomms.bookorderservice.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class BookOrderController {

  @Autowired
  private BookOrderService bookOrderService;

  @GetMapping("/bookorders")
  public List<BookOrder> getAllBookOrders(){
    return bookOrderService.getAllBookOrders();
  }

  @GetMapping("/bookorders/customer/{custid}")
  public List<BookOrder> getBookOrdersByCustid(@PathVariable String custid){
    return bookOrderService.getBookOrdersByCustid(custid);
  }

  @GetMapping("/bookorders/{id}")
  public Optional<BookOrder> getBookOrder(@PathVariable Long id) {
    return bookOrderService.getBookOrder(id);
  }

  @PostMapping("/bookorders")
  public ResponseEntity createBookOrder(@RequestBody BookOrder bookOrder){

    bookOrderService.createBookOrder(bookOrder);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PutMapping("/bookorders")
  public void editBookOrder(@RequestBody BookOrder bookOrder){

    bookOrderService.editBookOrder(bookOrder);
  }

  @DeleteMapping("/bookorders/{id}")
  public void deleteBookOrder(@PathVariable Long id){

    bookOrderService.deleteBookOrder(id);
  }

}

package com.lynch.ms.bomms.bookorderservice.service;

import com.lynch.ms.bomms.bookorderservice.model.BookOrder;
import com.lynch.ms.bomms.bookorderservice.repository.BookOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookOrderService {

  static final Logger log = LoggerFactory.getLogger(BookOrderService.class);

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  private BookOrderRepository bookOrderRepository;

  private final RabbitTemplate rabbitTemplate;

  private final Exchange exchange;

  public BookOrderService(RabbitTemplate rabbitTemplate, Exchange exchange) {
    this.rabbitTemplate = rabbitTemplate;
    this.exchange = exchange;
  }

  public List<BookOrder> getAllBookOrders(){

    return bookOrderRepository.findAll();
  }

  public Optional<BookOrder> getBookOrder(Long id) {

    return bookOrderRepository.findById(id);
  }

  public List<BookOrder> getBookOrdersByCustid(String custId){

  return bookOrderRepository.getBookOrdersByCustId(custId);
  }

  public void createBookOrder(BookOrder bookOrder){
    String routingKey = "order.created";
    String message = "Order created";
    rabbitTemplate.convertAndSend(exchange.getName(), routingKey, message);
    log.debug("BookOrder Service - Order being saved: {}", bookOrder);
    bookOrderRepository.save(bookOrder);
  }

  public void editBookOrder(BookOrder bookOrder){

    bookOrderRepository.save(bookOrder);
  }

  public void deleteBookOrder(Long id){

    bookOrderRepository.deleteById(id);
  }
}

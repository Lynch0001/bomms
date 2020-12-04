package com.lynch.ms.bomms.ackservice.orderacknowledge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

  private Logger logger = LoggerFactory.getLogger(OrderEventConsumer.class);

  // @RabbitListener(queues="orderServiceQueue")
  public void receive(String message) {
    logger.info("Received message '{}'", message);
  }
}

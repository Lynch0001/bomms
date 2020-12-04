package com.lynch.ms.bomms.bookorderservice.config;

import com.lynch.ms.bomms.bookorderservice.service.BookOrderService;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventProducerConfig {

  @Bean
  public Exchange eventExchange() {
    return new TopicExchange("orderEventExchange");
  }

  @Bean
  public BookOrderService bookOrderServiceService(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
    return new BookOrderService(rabbitTemplate, eventExchange);
  }

}

package com.lynch.ms.bomms.ackservice.orderacknowledge.config;

import com.lynch.ms.bomms.ackservice.orderacknowledge.service.OrderEventConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConsumerConfig implements ApplicationListener<ApplicationReadyEvent> {

  private Logger logger = LoggerFactory.getLogger(EventConsumerConfig.class);

  static final String topicExchangeName = "orderEventExchange";

  static final String queueName = "orderServiceQueue";

  static final String routingKey = "order.created";

    @Bean
    public Exchange eventExchange() {
      return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Queue queue() {
      return new Queue(queueName);
    }

    @Bean
    public BindingBuilder.GenericArgumentsConfigurer binding(Queue queue, Exchange eventExchange) {
      return BindingBuilder
              .bind(queue)
              .to(eventExchange)
              .with(routingKey);
    }

  @Bean
  public MessageConverter jsonMessageConverter(){
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                           MessageListenerAdapter listenerAdapter) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(queueName);
    container.setMessageListener(listenerAdapter);
    return container;
  }

  @Bean
  MessageListenerAdapter listenerAdapter(OrderEventConsumer orderEventConsumer) {
    return new MessageListenerAdapter(orderEventConsumer, "receive");
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    logger.info("SUBSCRIBING TO EVENTS MATCHING KEY '{}' FROM QUEUE '{}'!", routingKey, queueName);
  }
}

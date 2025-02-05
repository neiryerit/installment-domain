package com.melita.orderpub.publisher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.melita.orderpub.domain.dto.OrderDto;

@Component
public class OrderPublisher {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    public void publishOrder(OrderDto order) {
        log.debug("exchange: {} routingkey:{} order:{} ", exchange, routingKey, order.toString());
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
        log.debug("Published order: {}", order);
    }
}
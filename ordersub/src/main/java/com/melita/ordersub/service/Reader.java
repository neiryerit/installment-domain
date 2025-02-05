package com.melita.ordersub.service;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.melita.ordersub.domain.dto.OrderDto;
import com.melita.ordersub.mapper.IOrderMapper;
import com.melita.ordersub.model.Order;
import com.melita.ordersub.repository.IOrderRepo;

import jakarta.mail.MessagingException;

@Component
public class Reader {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    IOrderRepo orderRepo;

    @Autowired EmailService emailServ;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void receiveOrder(String msg) throws JsonMappingException, JsonProcessingException, MessagingException {
        
        log.info("Received order: " + msg);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Register module for Java 8 date types
        OrderDto orderDto = mapper.readValue(msg, OrderDto.class);

       // Order orderEntity = IOrderMapper.INSTANCE.toOrderEntity(orderDto);

       log.info("sending email...");
        emailServ.sendEmail("neiryerit@hotmail.com", "authorize order", msg);
        log.info("sent email");
        // saveIntoDB(order);
    }

    private void sendEmail(String order) {


    }

    private void saveIntoDB(OrderDto order) {
        log.info("message= {}", order.toString());
    }
}

package com.melita.orderpub.service;

import com.melita.orderpub.domain.dto.OrderDto;
import com.melita.orderpub.publisher.OrderPublisher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    private final Logger log = LogManager.getLogger(OrderService.class);

    @Autowired OrderPublisher pub;

    @Override
    public void receiveOrder(OrderDto order) {
        log.debug("received order: {}", order);

        pub.publishOrder(order);

    }
}

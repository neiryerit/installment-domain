package com.melita.orderpub.controller;

import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melita.orderpub.domain.dto.OrderDto;
import com.melita.orderpub.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final Logger log = LogManager.getLogger(this.getClass());

    @Autowired
    private IOrderService orderServ;

    @PostMapping(consumes = { "application/json; charset=UTF-8" })
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderDto order) {

        log.info("init createOrder");
        orderServ.receiveOrder(order);
        log.info("createOrder finished successfully");
        return ResponseEntity.accepted().build();
    }
}

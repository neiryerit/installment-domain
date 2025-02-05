package com.melita.orderpub.service;

import com.melita.orderpub.domain.dto.OrderDto;

public interface IOrderService {

    void receiveOrder(OrderDto order);
}

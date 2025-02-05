package com.melita.ordersub.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melita.ordersub.model.Order;

public interface IOrderRepo extends JpaRepository<Order, UUID>{

}

package com.melita.ordersub.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melita.ordersub.domain.Address;
import com.melita.ordersub.domain.Customer;
import com.melita.ordersub.domain.Product;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class OrderDto {

    private Customer customer;
    private Address installAddress;
    private List<Product> productList;
    private LocalDate preferredDate;
    @JsonFormat(pattern = "HH:mm") 
    private LocalTime timeSlotStart;
    @JsonFormat(pattern = "HH:mm") 
    private LocalTime timeSlotEnd;
}

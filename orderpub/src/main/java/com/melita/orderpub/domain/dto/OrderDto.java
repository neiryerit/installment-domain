package com.melita.orderpub.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.melita.orderpub.domain.Address;
import com.melita.orderpub.domain.Customer;
import com.melita.orderpub.domain.Product;
import jakarta.validation.Valid;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class OrderDto {
    @Valid
    private Customer customer;
    @Valid
    private Address installAddress;
    @Valid
    private List<Product> productList;
    private LocalDate preferredDate;
    @JsonFormat(pattern = "HH:mm") 
    private LocalTime timeSlotStart;
    @JsonFormat(pattern = "HH:mm") 
    private LocalTime timeSlotEnd;
}

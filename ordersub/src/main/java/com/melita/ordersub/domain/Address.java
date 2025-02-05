package com.melita.ordersub.domain;

import lombok.Data;

@Data
public class Address {
    
    private String street;
    private String complement;
    private String city;
    private String country;
    private String postalCode;
}

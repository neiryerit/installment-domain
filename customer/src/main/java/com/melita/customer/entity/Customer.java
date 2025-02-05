package com.melita.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    @Id
    private long id;

    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "first_names")
    private String firstNames;
    @Column(name = "surnames")
    private String surnames;
    private String email;
    private String phone;
    @Column(name = "full_address")
    private String fullAddress;
}

package com.melita.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bundle {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bundle_id")
    @Id
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}

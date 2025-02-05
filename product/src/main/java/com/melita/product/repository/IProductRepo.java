package com.melita.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.melita.product.entity.Product;

public interface IProductRepo extends JpaRepository<Product, Long> {


}

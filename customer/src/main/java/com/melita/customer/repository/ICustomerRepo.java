package com.melita.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.melita.customer.entity.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {

    public Customer findByDocumentNumber(String documentNumber);

}

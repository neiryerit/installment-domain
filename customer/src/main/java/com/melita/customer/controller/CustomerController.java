package com.melita.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.melita.customer.dto.CustomerReq;
import com.melita.customer.dto.CustomerResp;
import com.melita.customer.exception.StandarizedException;
import com.melita.customer.service.ICustomerServ;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerServ customerServ;

    @PostMapping(consumes = {"application/json; charset=UTF-8" }, produces = {"application/json; charset=UTF-8" })
    public ResponseEntity<CustomerResp> takeOrder(@Valid @RequestBody CustomerReq customerReq){

        CustomerResp customerResp = customerServ.takeOrder(customerReq);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerResp);
    }

    @GetMapping(path = "/{id}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<?> getById(@PathVariable long id) throws StandarizedException{

        CustomerResp customerResp = customerServ.getById(id);
        return ResponseEntity.ok().body(customerResp);
    }

    @GetMapping(produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<?> getByDocument(@RequestParam String documentNumber) throws StandarizedException{

        CustomerResp customerResp = customerServ.getByDocument(documentNumber);
        return ResponseEntity.ok().body(customerResp);
    }

}

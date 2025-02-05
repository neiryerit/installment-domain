package com.melita.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.melita.customer.dto.CustomerReq;
import com.melita.customer.dto.CustomerResp;
import com.melita.customer.entity.Customer;
import com.melita.customer.exception.StandarizedException;
import com.melita.customer.mapper.ICustomerReqMapper;
import com.melita.customer.mapper.ICustomerRespMapper;
import com.melita.customer.repository.ICustomerRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CustomerServ implements ICustomerServ {

    @Autowired
    ICustomerReqMapper custReqMapp;
    @Autowired
    ICustomerRespMapper custRespMapp;

    @Autowired
    ICustomerRepo customerRepo;

    @Override
    public CustomerResp takeOrder(CustomerReq customerReq) {
        Customer customer = custReqMapp.toEntity(customerReq);
        Customer newCustEntity = customerRepo.save(customer);
        CustomerResp newCustResp = custRespMapp.toDto(newCustEntity);

        return newCustResp;
    }

    @Override
    public CustomerResp getById(long id) throws StandarizedException {
        try {
            Customer foundCust = customerRepo.getReferenceById(id);
            CustomerResp customerResp = custRespMapp.toDto(foundCust);

            return customerResp;
        } catch (EntityNotFoundException ex) {
            throw new StandarizedException("001", "Unable to find Customer with id=" + id, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public CustomerResp getByDocument(String idDocument) throws StandarizedException {

        Customer foundCust = customerRepo.findByDocumentNumber(idDocument);
        if(foundCust==null){
            throw new StandarizedException("001", "Unable to find Customer with document=" + idDocument, HttpStatus.NOT_FOUND);
        }
        CustomerResp customerResp = custRespMapp.toDto(foundCust);

        return customerResp;
    }

}

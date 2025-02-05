package com.melita.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.melita.product.dto.ProductReq;
import com.melita.product.dto.ProductResp;
import com.melita.product.entity.Product;
import com.melita.product.exception.StandarizedException;
import com.melita.product.mapper.IProductReqMapper;
import com.melita.product.mapper.IProductrRespMapper;
import com.melita.product.repository.IProductRepo;
import com.melita.product.service.IProductServ;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServ implements IProductServ {

    @Autowired
    IProductReqMapper productReqMapper;
    @Autowired
    IProductrRespMapper productRespMapp;

    @Autowired
    IProductRepo productRepo;

    @Override
    public ProductResp save(ProductReq productReq) {
        Product product = productReqMapper.toProduct(productReq);
        Product newCustEntity = productRepo.save(product);
        ProductResp newProductResp = productRespMapp.toProductResp(newCustEntity);

        return newProductResp;
    }

    @Override
    public ProductResp getById(long id) throws StandarizedException {
        try {
            Product founProduct = productRepo.getReferenceById(id);
            ProductResp productResp = productRespMapp.toProductResp(founProduct);

            return productResp;
        } catch (EntityNotFoundException ex) {
            throw new StandarizedException("001", "Unable to find product with id=" + id, HttpStatus.NOT_FOUND);
        }

    }

}

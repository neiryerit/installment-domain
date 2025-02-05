package com.melita.product.service;

import com.melita.product.dto.ProductReq;
import com.melita.product.dto.ProductResp;
import com.melita.product.exception.StandarizedException;

public interface IProductServ {

    ProductResp save(ProductReq ProductReq);
    ProductResp getById(long id) throws StandarizedException;
}

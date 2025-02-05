package com.melita.customer.service;

import com.melita.customer.dto.CustomerReq;
import com.melita.customer.dto.CustomerResp;
import com.melita.customer.exception.StandarizedException;

public interface ICustomerServ {

    CustomerResp takeOrder(CustomerReq customerReq);
    CustomerResp getById(long id) throws StandarizedException;
    CustomerResp getByDocument(String idDocument) throws StandarizedException;
}

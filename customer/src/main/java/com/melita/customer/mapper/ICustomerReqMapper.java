package com.melita.customer.mapper;

import org.mapstruct.Mapper;

import com.melita.customer.dto.CustomerReq;
import com.melita.customer.entity.Customer;

@Mapper(componentModel = "spring")
public interface ICustomerReqMapper {

    public Customer toEntity(CustomerReq customerReq);
}

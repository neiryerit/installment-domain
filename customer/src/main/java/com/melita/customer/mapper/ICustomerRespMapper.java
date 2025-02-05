package com.melita.customer.mapper;

import org.mapstruct.Mapper;

import com.melita.customer.dto.CustomerResp;
import com.melita.customer.entity.Customer;

@Mapper(componentModel = "spring")
public interface ICustomerRespMapper {

    CustomerResp toDto(Customer customer);
}

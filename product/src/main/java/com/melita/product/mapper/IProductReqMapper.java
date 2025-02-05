package com.melita.product.mapper;

import org.mapstruct.Mapper;

import com.melita.product.dto.ProductReq;
import com.melita.product.entity.Product;

@Mapper(componentModel = "spring")
public interface IProductReqMapper {

    Product toProduct(ProductReq productReqReq);
}

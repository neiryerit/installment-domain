package com.melita.product.mapper;

import org.mapstruct.Mapper;

import com.melita.product.dto.ProductResp;
import com.melita.product.entity.Product;

@Mapper(componentModel = "spring")
public interface IProductrRespMapper {

    ProductResp toProductResp(Product product);
}

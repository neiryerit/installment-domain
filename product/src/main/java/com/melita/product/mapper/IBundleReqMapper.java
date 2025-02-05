package com.melita.product.mapper;

import org.mapstruct.Mapper;

import com.melita.product.dto.BundleReq;
import com.melita.product.entity.Bundle;

@Mapper(componentModel = "spring")
public interface IBundleReqMapper {

    Bundle toBundle(BundleReq bundleReq);
    
} 

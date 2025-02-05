package com.melita.product.mapper;

import org.mapstruct.Mapper;

import com.melita.product.dto.BundleResp;
import com.melita.product.entity.Bundle;

@Mapper(componentModel = "spring")
public interface IBundleRespMapper {

    BundleResp toBundleResp(Bundle bundle);
}

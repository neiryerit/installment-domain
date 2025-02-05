package com.melita.product.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.melita.product.dto.ProductBundles;
import com.melita.product.dto.BundleBasic;
import com.melita.product.entity.Bundle;
import com.melita.product.entity.Product;

@Mapper(componentModel = "spring")
public interface IProducBundlesMapper {

    @Mappings({
        @Mapping(source = "id", target = "productId"),
        @Mapping(source = "name", target = "productName")
    })
    ProductBundles toBundleProduct(Product bundleReq);

    List<BundleBasic> toBundleProductList(List<Bundle> bundles);
    
} 

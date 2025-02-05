package com.melita.product.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBundles {

    private long productId;
    private String productName;
    private List<BundleBasic> bundles;
}

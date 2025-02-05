package com.melita.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BundleResp {

    private long id;
    private String name;
    private ProductResp product;
}

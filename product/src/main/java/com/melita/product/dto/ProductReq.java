package com.melita.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReq {

    @NotBlank(message = "is missing")
    private String name;
    
}

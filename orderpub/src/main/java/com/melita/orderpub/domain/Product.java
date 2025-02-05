package com.melita.orderpub.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Product {

    @NotBlank(message = "is missing")
    private String name;
    @NotBlank(message = "is missing")
    private String packageName;
}

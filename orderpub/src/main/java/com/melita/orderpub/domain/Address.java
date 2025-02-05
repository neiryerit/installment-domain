package com.melita.orderpub.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Address {
    @NotBlank(message = "is missing")
    private String street;
    private String complement;
    @NotBlank(message = "is missing")
    private String city;
    @NotBlank(message = "is missing")
    private String country;
    @NotBlank(message = "is missing")
    private String postalCode;
}

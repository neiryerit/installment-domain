package com.melita.customer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerReq {

    @NotBlank(message = "is missing")
    private String documentNumber;
    @NotBlank(message = "is missing")
    private String firstNames;
    @NotBlank(message = "is missing")
    private String surnames;
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}$", message = "Invalid format")
    private String email;
    @NotBlank(message = "is missing")
    private String phone;
    @NotBlank(message = "is missing")
    private String fullAddress;
    
}

package com.melita.orderpub.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Customer {
    @NotBlank(message = "is missing")
    private String firstName;
    @NotBlank(message = "is missing")
    private String lastName;
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}$", message = "Invalid format")
    private String email;
    @NotBlank(message = "is missing")
    private String phone;
}

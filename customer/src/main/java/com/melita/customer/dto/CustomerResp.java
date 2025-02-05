package com.melita.customer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResp {

    private long id;
    private String documentNumber;
    private String firstNames;
    private String surnames;
    private String email;
    private String phone;
    private String fullAddress;

}

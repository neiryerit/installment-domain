package com.melita.product.exception;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMsg {

    private List<String> errors;

    ErrorMsg(List<String> errors){
        this.errors = errors;   
    }
}

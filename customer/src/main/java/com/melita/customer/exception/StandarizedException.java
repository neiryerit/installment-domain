package com.melita.customer.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandarizedException extends Exception{

    private String code;   
    private HttpStatus httpStatus;

    public StandarizedException(String code, String message, HttpStatus httpStatus){
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public StandarizedException(String code, String message, HttpStatus httpStatus, Throwable cause){
        super(message, cause);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}

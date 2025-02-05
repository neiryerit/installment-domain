package com.melita.ordersub.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.melita.ordersub.domain.Error;

import jakarta.servlet.http.HttpServletRequest;
/*
 * Class aimed for controling all exceptions and give a customized response to the consumer
 * while the whole stack error is wrote in the execution console of the project.
 * All application errors will be caught here
 */
@RestControllerAdvice
public class ErrorHandler {

    private Logger log = LogManager.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    public void handleAllErrors(HttpServletRequest req, Exception ex) {

        log.error("UNKNOWN ERROR is: {}", ex.getMessage());

        Arrays.stream(ex.getStackTrace()).limit(10).forEach(x -> {
            log.error("class:{} - method:{} - line:{}", x.getClassName(), x.getMethodName(), x.getLineNumber());
        });
        
    }

}

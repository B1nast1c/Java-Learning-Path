package com.testing.spring.enterprise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundEnterprise extends RuntimeException {
    public NotFoundEnterprise(String message){
        super(message);
    }
}

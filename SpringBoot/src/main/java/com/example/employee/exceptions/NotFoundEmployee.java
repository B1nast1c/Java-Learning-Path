package com.example.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundEmployee extends RuntimeException {
    public NotFoundEmployee(String message){
        super(message);
    }
}

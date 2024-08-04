package com.example.shopbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ShopNotFoundException extends RuntimeException {

    private String message;

    public ShopNotFoundException(String message) {
        super(message);
    }
}

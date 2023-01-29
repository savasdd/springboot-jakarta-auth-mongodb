package com.jakarta.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionThrow extends Exception{

    private static final long serialVersionUID = -4969321983366153553L;

    public ExceptionThrow(String msg) {
        super(msg);
    }
}

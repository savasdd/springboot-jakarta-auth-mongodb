package com.jakarta.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExceptionThrow.class)
    public ResponseEntity<?> kayitBulunamadi(ExceptionThrow exception, WebRequest request) throws ExceptionThrow {
        Object hata = exception.getStackTrace();
        ExceptionBody detay = new ExceptionBody(exception.getMessage(),HttpStatus.NOT_FOUND.value(),getTime(new Date()));
        return new ResponseEntity<>(detay, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalHata(Exception ex, WebRequest request) throws ExceptionThrow {
        Object hata = ex.getStackTrace();
        ExceptionBody detay = new ExceptionBody(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value(),getTime(new Date()));

        // Log

        return new ResponseEntity<>(detay, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static LocalDateTime getTime(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}

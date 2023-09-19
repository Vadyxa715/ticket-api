package com.example.testparttwo.controller.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handlerException(EntityNotFoundException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Not found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(EntityBadRequestException.class)
    public ResponseEntity<Object> handlerException(EntityBadRequestException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Bad Request.");
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

}

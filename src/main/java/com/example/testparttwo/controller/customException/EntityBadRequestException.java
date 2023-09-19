package com.example.testparttwo.controller.customException;

public class EntityBadRequestException extends RuntimeException{
    public EntityBadRequestException(String message) {
        super(message);
    }
}

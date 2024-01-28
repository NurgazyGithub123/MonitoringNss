package com.example.monitoringNss.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String massage){
        super(massage);
    }
}

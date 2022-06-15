package com.example.projekt2.exception;

public class SeansNotFoundException extends RuntimeException{

    public SeansNotFoundException(Long id){
        super("Could not find a seans with id: "+id);
    }
}

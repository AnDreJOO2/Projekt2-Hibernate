package com.example.projekt2.exception;

public class CinemaNotFoundException extends RuntimeException{

    public CinemaNotFoundException(Long id){
        super("Could not find a cinema with id: "+id);
    }
}

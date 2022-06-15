package com.example.projekt2.exception;

public class DirectorNotFoundException extends RuntimeException{

    public DirectorNotFoundException(Long id){
        super("Could not find a director with id: "+id);
    }
}

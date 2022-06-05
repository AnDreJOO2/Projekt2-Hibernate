package com.example.projekt2.exception;

public class FilmNotFoundException extends RuntimeException{

    public FilmNotFoundException(Long id){
        super("Could not find a film with id: "+id);
    }
}

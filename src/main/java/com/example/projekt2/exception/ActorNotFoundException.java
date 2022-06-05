package com.example.projekt2.exception;

public class ActorNotFoundException extends RuntimeException{

    public ActorNotFoundException(Long id){
        super("Could not find an actor with id: "+id);
    }
}

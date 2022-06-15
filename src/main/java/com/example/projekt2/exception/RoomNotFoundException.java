package com.example.projekt2.exception;

public class RoomNotFoundException extends RuntimeException{

    public RoomNotFoundException(Long id){
        super("Could not find a room with id: "+id);
    }
}

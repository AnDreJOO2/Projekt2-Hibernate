package com.example.projekt2.controller.controllerException;

import com.example.projekt2.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FilmNotFoundException.class)
    public ResponseEntity<String> filmNotFoundHandler(FilmNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ActorNotFoundException.class)
    public ResponseEntity<String> actorNotFoundHandler(ActorNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<String> roomNotFoundHandler(RoomNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DirectorNotFoundException.class)
    public ResponseEntity<String> directorNotFoundHandler(DirectorNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CinemaNotFoundException.class)
    public ResponseEntity<String> cinemaNotFoundHandler(CinemaNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SeansNotFoundException.class)
    public ResponseEntity<String> showNotFoundHandler(SeansNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}

package com.example.projekt2.controller;

import com.example.projekt2.model.dto.ActorDto;
import com.example.projekt2.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.projekt2.model.mapper.ActorMapper.mapActorListToActorDtoList;
import static com.example.projekt2.model.mapper.ActorMapper.mapActorToActorDto;

@RestController
@RequestMapping("api")
public class ActorController {


    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("actors")
    public ResponseEntity<List<ActorDto>> getActors() {
        return new ResponseEntity<>(mapActorListToActorDtoList(actorService.getActorList()), HttpStatus.OK);
    }

    @GetMapping("actors/{id}")
    public ResponseEntity<ActorDto> getActorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapActorToActorDto().apply(actorService.getActorById(id)), HttpStatus.OK);
    }

}

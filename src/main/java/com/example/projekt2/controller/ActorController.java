package com.example.projekt2.controller;

import com.example.projekt2.model.dto.ActorReadDto;
import com.example.projekt2.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<ActorReadDto>> getActors(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int pageNumber = (page<1) ? 1 : page;
        return new ResponseEntity<>(mapActorListToActorDtoList(actorService.getActorList(pageNumber-1)), HttpStatus.OK);
    }

    @GetMapping("actors/{id}")
    public ResponseEntity<ActorReadDto> getActorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapActorToActorDto().apply(actorService.getActorById(id)), HttpStatus.OK);
    }

    @DeleteMapping("actors/{id}")
    public ResponseEntity<?> deleteActorById(@PathVariable("id") Long id) {
        actorService.deleteActorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

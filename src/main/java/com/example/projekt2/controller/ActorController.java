package com.example.projekt2.controller;

import com.example.projekt2.model.Actor;
import com.example.projekt2.model.dto.read.ActorReadDto;
import com.example.projekt2.model.dto.read.FilmReadDto;
import com.example.projekt2.model.dto.write.ActorWriteDto;
import com.example.projekt2.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.projekt2.model.mapper.ActorMapper.mapActorListToActorDtoList;
import static com.example.projekt2.model.mapper.ActorMapper.mapActorToActorDto;
import static com.example.projekt2.model.mapper.FilmMapper.mapFilmListToFilmReadDtoList;

@RestController
@RequestMapping("api")
public class ActorController {


    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping(value = "actors", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ActorReadDto>> getActors(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                        @RequestParam(value = "olderThan", required = false, defaultValue = "0") int olderThan) {
        int pageNumber = (page < 1) ? 1 : page;
        int ageValue = (olderThan <= 0) ? 0 : olderThan;
        return new ResponseEntity<>(mapActorListToActorDtoList(actorService.getActorList(pageNumber - 1, ageValue)), HttpStatus.OK);
    }

    @GetMapping(value = "actors/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ActorReadDto> getActorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapActorToActorDto().apply(actorService.getActorById(id)), HttpStatus.OK);
    }

    @GetMapping(value = "actors/{id}/films", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<FilmReadDto>> getActorFilmsByActorId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapFilmListToFilmReadDtoList(actorService.getActorFilms(id)), HttpStatus.OK);
    }

    @PostMapping("actors")
    public ResponseEntity<Actor> addActor(@Valid @RequestBody ActorWriteDto actor) {

        return new ResponseEntity<>(actorService.addActor(actor), HttpStatus.CREATED);
    }

    @PutMapping("actors/{id}")
    public ResponseEntity<Actor> editActor(@PathVariable("id") Long id, @RequestBody Actor actor) {
        return new ResponseEntity<>(actorService.editActor(actor, id), HttpStatus.OK);
    }


    @DeleteMapping("actors/{id}")
    public ResponseEntity<?> deleteActorById(@PathVariable("id") Long id) {
        actorService.deleteActorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

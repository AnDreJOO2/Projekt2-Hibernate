package com.example.projekt2.controller;

import com.example.projekt2.model.dto.FilmReadDto;
import com.example.projekt2.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.projekt2.model.mapper.FilmMapper.mapFilmListToFilmReadDtoList;
import static com.example.projekt2.model.mapper.FilmMapper.mapFilmToFilmReadDto;

@RestController
@RequestMapping("api")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("films")
    public ResponseEntity<List<FilmReadDto>> getFilms() {
        return new ResponseEntity<>(mapFilmListToFilmReadDtoList(filmService.getAllFilms()), HttpStatus.OK);
    }

    @GetMapping("films/{id}")
    public ResponseEntity<FilmReadDto> getFilmById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapFilmToFilmReadDto().apply(filmService.getFilmById(id)), HttpStatus.OK);
    }
}

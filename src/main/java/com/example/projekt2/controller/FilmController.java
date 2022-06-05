package com.example.projekt2.controller;

import com.example.projekt2.model.dto.FilmDto;
import com.example.projekt2.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.projekt2.model.mapper.FilmMapper.mapFilmListToFilmDtoList;
import static com.example.projekt2.model.mapper.FilmMapper.mapFilmToFilmDto;

@RestController
@RequestMapping("api")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("films")
    public ResponseEntity<List<FilmDto>> getFilms() {
        return new ResponseEntity<>(mapFilmListToFilmDtoList(filmService.getAllFilms()), HttpStatus.OK);
    }

    @GetMapping("films/{id}")
    public ResponseEntity<FilmDto> getFilmById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapFilmToFilmDto().apply(filmService.getFilmById(id)), HttpStatus.OK);
    }
}

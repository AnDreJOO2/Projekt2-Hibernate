package com.example.projekt2.controller;

import com.example.projekt2.model.dto.FilmReadDto;
import com.example.projekt2.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.projekt2.model.mapper.FilmMapper.*;

@RestController
@RequestMapping("api")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("films")
    public ResponseEntity<List<FilmReadDto>> getFilms(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int pageNumber = (page < 1) ? 1 : page;

        return new ResponseEntity<>(mapFilmListToFilmReadDtoList(filmService.getAllFilms(pageNumber - 1)), HttpStatus.OK);
    }

    @GetMapping("films/details")
    public ResponseEntity<List<FilmReadDto>> getFilmsWithDetails(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int pageNumber = (page < 1) ? 1 : page;

        return new ResponseEntity<>(mapFilmListToFilmReadDtoListWithDetails(filmService.getAllFilms(pageNumber - 1)), HttpStatus.OK);
    }

    @GetMapping("films/{id}")
    public ResponseEntity<FilmReadDto> getFilmById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapFilmToFilmReadDto().apply(filmService.getFilmById(id)), HttpStatus.OK);
    }

    @DeleteMapping ("films/{id}")
    public ResponseEntity<?> deleteFilmById(@PathVariable("id") Long id) {
        filmService.deleteFilmById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

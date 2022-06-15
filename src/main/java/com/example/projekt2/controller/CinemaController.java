package com.example.projekt2.controller;

import com.example.projekt2.model.dto.CinemaReadDto;
import com.example.projekt2.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.projekt2.model.mapper.CinemaMapper.mapCinemaListToCinemaReadDtoList;
import static com.example.projekt2.model.mapper.CinemaMapper.mapCinemaToCinemaReadDto;

@RestController
@RequestMapping("api")
public class CinemaController {
    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("cinemas")
    public ResponseEntity<List<CinemaReadDto>> getCinemas() {
        return new ResponseEntity<>(mapCinemaListToCinemaReadDtoList(cinemaService.getAllCinemas()), HttpStatus.OK);
    }

    @GetMapping("cinemas/{id}")
    public ResponseEntity<CinemaReadDto> getCinemaById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapCinemaToCinemaReadDto().apply(cinemaService.getCinemaById(id)), HttpStatus.OK);
    }
}
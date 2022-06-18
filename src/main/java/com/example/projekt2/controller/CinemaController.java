package com.example.projekt2.controller;

import com.example.projekt2.model.Cinema;
import com.example.projekt2.model.dto.read.CinemaReadDto;
import com.example.projekt2.model.dto.write.CinemaWriteDto;
import com.example.projekt2.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = "cinemas", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<CinemaReadDto>> getCinemas(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int pageNumber = (page<1) ? 1 : page;
        return new ResponseEntity<>(mapCinemaListToCinemaReadDtoList(cinemaService.getAllCinemas(pageNumber-1)), HttpStatus.OK);
    }

    @GetMapping(value = "cinemas/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CinemaReadDto> getCinemaById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapCinemaToCinemaReadDto().apply(cinemaService.getCinemaById(id)), HttpStatus.OK);
    }

    @PostMapping(value = "cinemas", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Cinema> addCinema(@Valid @RequestBody CinemaWriteDto cinema) {
        return new ResponseEntity<>(cinemaService.addCinema(cinema), HttpStatus.CREATED);
    }

    @PutMapping(value = "cinemas/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Cinema> editCinema(@PathVariable("id") Long id,@Valid @RequestBody CinemaWriteDto cinema) {
        return new ResponseEntity<>(cinemaService.editCinema(cinema, id), HttpStatus.OK);
    }

    @DeleteMapping("cinemas/{id}")
    public ResponseEntity<?> deleteCinemaById(@PathVariable("id") Long id) {
        cinemaService.deleteCinemaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

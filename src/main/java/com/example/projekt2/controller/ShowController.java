package com.example.projekt2.controller;

import com.example.projekt2.model.dto.SeansReadDto;
import com.example.projekt2.service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.projekt2.model.mapper.ShowMapper.mapShowListToShowReadDtoList;
import static com.example.projekt2.model.mapper.ShowMapper.mapShowToShowsReadDto;

@RestController
@RequestMapping("api")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping(value = "shows", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<SeansReadDto>> getShows(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int pageNumber = (page < 1) ? 1 : page;
        return new ResponseEntity<>(mapShowListToShowReadDtoList(showService.getAllShows(pageNumber - 1)), HttpStatus.OK);
    }

    @GetMapping(value = "shows/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SeansReadDto> getShowById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapShowToShowsReadDto().apply(showService.getShowById(id)), HttpStatus.OK);
    }

    @DeleteMapping("shows/{id}")
    public ResponseEntity<?> deleteShowById(@PathVariable("id") Long id) {
        showService.deleteShowById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

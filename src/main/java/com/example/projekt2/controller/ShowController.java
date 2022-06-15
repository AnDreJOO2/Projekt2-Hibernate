package com.example.projekt2.controller;

import com.example.projekt2.model.dto.SeansReadDto;
import com.example.projekt2.service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("shows")
    public ResponseEntity<List<SeansReadDto>> getShows() {
        return new ResponseEntity<>(mapShowListToShowReadDtoList(showService.getAllShows()), HttpStatus.OK);
    }

    @GetMapping("shows/{id}")
    public ResponseEntity<SeansReadDto> getShowById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapShowToShowsReadDto().apply(showService.getShowById(id)), HttpStatus.OK);
    }
}

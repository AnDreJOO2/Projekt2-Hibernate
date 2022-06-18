package com.example.projekt2.controller;

import com.example.projekt2.model.Seans;
import com.example.projekt2.model.dto.read.SeansReadDto;
import com.example.projekt2.model.dto.write.SeansWriteDto;
import com.example.projekt2.service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(value = "shows", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Seans> addShow(@Valid @RequestBody SeansWriteDto seans) {
        return new ResponseEntity<>(showService.addShow(seans), HttpStatus.CREATED);
    }

    @PutMapping(value = "shows/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Seans> editShow(@PathVariable("id") Long id,@Valid @RequestBody SeansWriteDto seans) {
        return new ResponseEntity<>(showService.editShow(seans, id), HttpStatus.OK);
    }

    @DeleteMapping("shows/{id}")
    public ResponseEntity<?> deleteShowById(@PathVariable("id") Long id) {
        showService.deleteShowById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

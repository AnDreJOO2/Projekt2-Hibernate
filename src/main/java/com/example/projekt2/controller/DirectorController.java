package com.example.projekt2.controller;

import com.example.projekt2.model.Director;
import com.example.projekt2.model.dto.read.DirectorReadDto;
import com.example.projekt2.model.dto.write.DirectorWriteDto;
import com.example.projekt2.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.projekt2.model.mapper.DirectorMapper.*;

@RestController
@RequestMapping("api")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping(value = "directors", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DirectorReadDto>> getDirectors(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int pageNumber = (page < 1) ? 1 : page;
        return new ResponseEntity<>(getDirectorReadDtoList(directorService.getAllDirectors(pageNumber - 1)), HttpStatus.OK);
    }

    @GetMapping(value = "directors/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DirectorReadDto> getDirectorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapDirectorToDirectorReadDtoAll().apply(directorService.getDirectorById(id)), HttpStatus.OK);
    }

    @PostMapping(value = "directors", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Director> addDirector(@Valid @RequestBody DirectorWriteDto director) {
        return new ResponseEntity<>(directorService.addDirector(director), HttpStatus.CREATED);
    }

    @PutMapping(value = "directors/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Director> editDirector(@PathVariable("id") Long id,@Valid @RequestBody DirectorWriteDto director) {
        return new ResponseEntity<>(directorService.editDirector(director, id), HttpStatus.OK);
    }

    @DeleteMapping("directors/{id}")
    public ResponseEntity<?> deleteDirectorById(@PathVariable("id") Long id) {
        directorService.deleteDirectorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

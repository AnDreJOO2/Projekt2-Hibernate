package com.example.projekt2.controller;

import com.example.projekt2.model.dto.DirectorReadDto;
import com.example.projekt2.service.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.projekt2.model.mapper.DirectorMapper.getDirectorReadDtoList;
import static com.example.projekt2.model.mapper.DirectorMapper.mapDirectorToDirectorReadDto;

@RestController
@RequestMapping("api")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("directors")
    public ResponseEntity<List<DirectorReadDto>> getDirectors() {
        return new ResponseEntity<>(getDirectorReadDtoList(directorService.getAllDirectors()), HttpStatus.OK);
    }

    @GetMapping("directors/{id}")
    public ResponseEntity<DirectorReadDto> getDirectorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapDirectorToDirectorReadDto().apply(directorService.getDirectorById(id)), HttpStatus.OK);
    }

    @DeleteMapping("directors/{id}")
    public ResponseEntity<?> deleteDirectorById(@PathVariable("id") Long id) {
        directorService.deleteDirectorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

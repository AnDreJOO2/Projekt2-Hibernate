package com.example.projekt2.service;

import com.example.projekt2.exception.DirectorNotFoundException;
import com.example.projekt2.model.Director;
import com.example.projekt2.model.Seans;
import com.example.projekt2.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    private Director findDirectorById(Long id){
        return directorRepository.findById(id).orElseThrow(() -> new DirectorNotFoundException(id));
    }

    public Director getDirectorById(Long id){
        return findDirectorById(id);
    }

    public List<Director> getAllDirectors(){
        return directorRepository.findAll();
    }

    public void deleteDirectorById(Long id) {
        Director toDelete = findDirectorById(id);
        directorRepository.delete(toDelete);
    }
}

package com.example.projekt2.service;

import com.example.projekt2.exception.DirectorNotFoundException;
import com.example.projekt2.model.Director;
import com.example.projekt2.repository.DirectorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    public static final int PAGE_SIZE = 5;

    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    private Director findDirectorById(Long id) {
        return directorRepository.findById(id).orElseThrow(() -> new DirectorNotFoundException(id));
    }

    public Director getDirectorById(Long id) {
        return findDirectorById(id);
    }

    public List<Director> getAllDirectors(int page) {
        return directorRepository.findAllDirectors(PageRequest.of(page, PAGE_SIZE));
    }

    public void deleteDirectorById(Long id) {
        Director toDelete = findDirectorById(id);
        directorRepository.delete(toDelete);
    }

    public Director addDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director editDirector(Director director, Long id) {
        Director toEdit = findDirectorById(id);
        toEdit.setName(director.getName());
        toEdit.setSurname(director.getSurname());
        toEdit.setAge(director.getAge());
        toEdit.setFilms(director.getFilms());
        return directorRepository.save(toEdit);
    }
}

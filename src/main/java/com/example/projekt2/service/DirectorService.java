package com.example.projekt2.service;

import com.example.projekt2.exception.DirectorNotFoundException;
import com.example.projekt2.model.Cinema;
import com.example.projekt2.model.Director;
import com.example.projekt2.model.dto.write.DirectorWriteDto;
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

    public Director addDirector(DirectorWriteDto director) {
        Director newDirector = new Director();
        //pola
        return directorRepository.save(newDirector);
    }

    public Director editDirector(DirectorWriteDto director, Long id) {
        Director toEdit = findDirectorById(id);
        toEdit.setName(director.name());
        toEdit.setSurname(director.surname());
        toEdit.setAge(director.age());
        //toEdit.setFilms(director.f());
        return directorRepository.save(toEdit);
    }
}

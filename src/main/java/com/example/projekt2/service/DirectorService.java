package com.example.projekt2.service;

import com.example.projekt2.exception.DirectorNotFoundException;
import com.example.projekt2.exception.FilmNotFoundException;
import com.example.projekt2.model.Director;
import com.example.projekt2.model.Film;
import com.example.projekt2.model.dto.write.DirectorWriteDto;
import com.example.projekt2.repository.DirectorRepository;
import com.example.projekt2.repository.FilmRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DirectorService {
    public static final int PAGE_SIZE = 5;

    private final DirectorRepository directorRepository;
    private final FilmRepository filmRepository;

    public DirectorService(DirectorRepository directorRepository, FilmRepository filmRepository) {
        this.directorRepository = directorRepository;
        this.filmRepository = filmRepository;
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

        newDirector.setName(director.name());
        newDirector.setSurname(director.surname());
        newDirector.setAge(director.age());

        if (director.filmsIds().size() > 0) {
            setDirectorFilms(director, newDirector);
        }

        return directorRepository.save(newDirector);
    }

    public Director editDirector(DirectorWriteDto director, Long id) {
        Director toEdit = findDirectorById(id);
        toEdit.setName(director.name());
        toEdit.setSurname(director.surname());
        toEdit.setAge(director.age());

        if (director.filmsIds().size() > 0) {
            deleteDirectorFilms(toEdit);
            setDirectorFilms(director, toEdit);
        }
        return directorRepository.save(toEdit);
    }

    private void deleteDirectorFilms(Director toEdit) {
        Set<Film> copyFilms = Set.copyOf(toEdit.getFilms());
        copyFilms.forEach(toEdit::removeFilm);
    }

    private void setDirectorFilms(DirectorWriteDto director, Director toEdit) {
        director.filmsIds().forEach(filmId -> toEdit.addFilm(filmRepository.findById(filmId).orElseThrow(() -> new FilmNotFoundException(filmId))));
    }
}

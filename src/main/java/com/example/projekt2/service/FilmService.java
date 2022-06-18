package com.example.projekt2.service;

import com.example.projekt2.exception.FilmNotFoundException;
import com.example.projekt2.model.Director;
import com.example.projekt2.model.Film;
import com.example.projekt2.model.dto.write.FilmWriteDto;
import com.example.projekt2.repository.FilmRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    public static final int PAGE_SIZE = 5;
    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    private Film findFilmById(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }

    public Film getFilmById(Long id) {
        return findFilmById(id);
    }

    public List<Film> getAllFilms(int page) {

        return filmRepository.findAllFilms(PageRequest.of(page, PAGE_SIZE));
    }

    public void deleteFilmById(Long id) {
        Film toDelete = findFilmById(id);
        filmRepository.delete(toDelete);
    }

    public Film addFilm(FilmWriteDto film) {
        Film newFilm = new Film();
        //pola
        return filmRepository.save(newFilm);
    }

    public Film editFilm(FilmWriteDto film, Long id) {
        Film toEdit = findFilmById(id);
        toEdit.setName(film.name());
        toEdit.setMinutes(film.minutes());
        toEdit.setReleased(film.released());
//        toEdit.setActors(film.actorsIds());
//        toEdit.setDirector(film.directorId());
        return filmRepository.save(toEdit);
    }
}

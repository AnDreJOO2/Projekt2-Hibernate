package com.example.projekt2.service;

import com.example.projekt2.exception.FilmNotFoundException;
import com.example.projekt2.model.Film;
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

    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    public Film editFilm(Film film, Long id) {
        Film toEdit = findFilmById(id);
        toEdit.setName(film.getName());
        toEdit.setMinutes(film.getMinutes());
        toEdit.setReleased(film.getReleased());
        toEdit.setActors(film.getActors());
        toEdit.setDirector(film.getDirector());
        return filmRepository.save(toEdit);
    }
}

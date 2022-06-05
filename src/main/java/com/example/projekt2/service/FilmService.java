package com.example.projekt2.service;

import com.example.projekt2.exception.FilmNotFoundException;
import com.example.projekt2.model.Film;
import com.example.projekt2.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    private Film findFilmById(Long id){
        return filmRepository.findById(id).orElseThrow(() -> new FilmNotFoundException(id));
    }

    public Film getFilmById(Long id){
        return findFilmById(id);
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

}

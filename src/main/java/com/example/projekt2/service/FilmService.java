package com.example.projekt2.service;

import com.example.projekt2.exception.ActorNotFoundException;
import com.example.projekt2.exception.DirectorNotFoundException;
import com.example.projekt2.exception.FilmNotFoundException;
import com.example.projekt2.model.Actor;
import com.example.projekt2.model.Director;
import com.example.projekt2.model.Film;
import com.example.projekt2.model.dto.write.FilmWriteDto;
import com.example.projekt2.repository.ActorRepository;
import com.example.projekt2.repository.DirectorRepository;
import com.example.projekt2.repository.FilmRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class FilmService {

    public static final int PAGE_SIZE = 5;
    private final FilmRepository filmRepository;
    private final DirectorRepository directorRepository;
    private final ActorRepository actorRepository;

    public FilmService(FilmRepository filmRepository, DirectorRepository directorRepository, ActorRepository actorRepository) {
        this.filmRepository = filmRepository;
        this.directorRepository = directorRepository;
        this.actorRepository = actorRepository;
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

    @Transactional
    public Film addFilm(FilmWriteDto film) {
        Film newFilm = new Film();
        newFilm.setName(film.name());
        newFilm.setReleased(film.released());
        newFilm.setMinutes(film.minutes());

        if (film.directorId() != null) {
            Director director = directorRepository.findById(film.directorId()).orElseThrow(() -> new DirectorNotFoundException(film.directorId()));
            newFilm.setDirector(director);
        }
        if (film.actorsIds().size() > 0) {
            setFilmActors(film, newFilm);
        }

        return filmRepository.save(newFilm);
    }

    @Transactional
    public Film editFilm(FilmWriteDto film, Long id) {
        Film toEdit = findFilmById(id);
        toEdit.setName(film.name());
        toEdit.setReleased(film.released());
        toEdit.setMinutes(film.minutes());

        if (film.directorId() != null) {
            Director director = directorRepository.findById(film.directorId()).orElseThrow(() -> new DirectorNotFoundException(film.directorId()));
            toEdit.removeDirector();
            toEdit.setDirector(director);
        }
        if (film.actorsIds().size() > 0) {
            deleteFilmActors(toEdit);
            setFilmActors(film, toEdit);
        }
        return filmRepository.save(toEdit);
    }

    private void deleteFilmActors(Film toEdit) {
        Set<Actor> copyActors = Set.copyOf(toEdit.getActors()); //kopia zbioru po którym przechodzę i kasuje elementy
        copyActors.forEach(toEdit::removeActor); //edycja dla aktora i dla filmów
    }

    private void setFilmActors(FilmWriteDto film, Film toEdit) {
        film.actorsIds().forEach(actorId -> toEdit.addActor(actorRepository.findById(actorId).orElseThrow(() -> new ActorNotFoundException(actorId))));
    }
}

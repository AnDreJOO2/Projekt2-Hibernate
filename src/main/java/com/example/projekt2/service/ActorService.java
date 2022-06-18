package com.example.projekt2.service;

import com.example.projekt2.exception.ActorNotFoundException;
import com.example.projekt2.exception.FilmNotFoundException;
import com.example.projekt2.model.Actor;
import com.example.projekt2.model.Film;
import com.example.projekt2.model.dto.write.ActorWriteDto;
import com.example.projekt2.repository.ActorRepository;
import com.example.projekt2.repository.FilmRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ActorService {

    public static final int PAGE_SIZE = 5;

    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;

    public ActorService(ActorRepository actorRepository, FilmRepository filmRepository) {
        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
    }

    private Actor findActorById(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new ActorNotFoundException(id));
    }

    public Actor getActorById(Long id) {
        return findActorById(id);
    }

    public List<Actor> getActorList(int page, int olderThan) {
        return actorRepository.findAllActors(PageRequest.of(page, PAGE_SIZE), olderThan);
    }

    public void deleteActorById(Long id) {
        Actor toDelete = findActorById(id);
        actorRepository.delete(toDelete);
    }

    public List<Film> getActorFilms(Long id) {
        Actor actor = findActorById(id);
        return actorRepository.findAllActorFilms(actor);
    }
    @Transactional
    public Actor addActor(ActorWriteDto actor) {
        Actor newActor = new Actor();
        newActor.setName(actor.name());
        newActor.setSurname(actor.surname());
        newActor.setAge(actor.age());
        if (actor.filmsIds().size() > 0) {
            setActorFilms(actor, newActor); //dodaje filmy do relacji jeśli istnieją
        }
        return actorRepository.save(newActor);
    }
    @Transactional
    public Actor editActor(ActorWriteDto actor, Long id) {
        Actor toEdit = findActorById(id);
        toEdit.setName(actor.name());
        toEdit.setSurname(actor.surname());
        toEdit.setAge(actor.age());

        if (actor.filmsIds().size() > 0) {
            deleteActorFilms(toEdit);
            setActorFilms(actor, toEdit);
        }

        return actorRepository.save(toEdit);
    }

    //copy of the actor's film set, then delete old relations
    //interations on the copy set to avoid ConcurrentModificationException
    private void deleteActorFilms(Actor toEdit) {
        Set<Film> copyFilms = Set.copyOf(toEdit.getFilms()); //kopia zbioru po którym przechodzę i kasuje elementy
        copyFilms.forEach(toEdit::removeFilm); //edycja dla aktora i dla filmów
    }


    //adding films to the actor and actor to the films
    private void setActorFilms(ActorWriteDto actor, Actor toEdit) {
        actor.filmsIds().forEach(filmId -> toEdit.addFilm(filmRepository.findById(filmId).orElseThrow(() -> new FilmNotFoundException(filmId))));
    }
}

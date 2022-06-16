package com.example.projekt2.service;

import com.example.projekt2.exception.ActorNotFoundException;
import com.example.projekt2.model.Actor;
import com.example.projekt2.model.Seans;
import com.example.projekt2.repository.ActorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    public static final int PAGE_SIZE = 5;

    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    private Actor findActorById(Long id){
        return actorRepository.findById(id).orElseThrow(()-> new ActorNotFoundException(id));
    }

    public Actor getActorById(Long id){
        return findActorById(id);
    }

    public List<Actor> getActorList(int page){
        return actorRepository.findAllActors(PageRequest.of(page,PAGE_SIZE));
    }

    public void deleteActorById(Long id) {
        Actor toDelete = findActorById(id);
        actorRepository.delete(toDelete);
    }
}

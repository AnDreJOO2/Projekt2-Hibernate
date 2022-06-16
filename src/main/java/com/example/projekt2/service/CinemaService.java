package com.example.projekt2.service;

import com.example.projekt2.exception.CinemaNotFoundException;
import com.example.projekt2.model.Cinema;
import com.example.projekt2.model.Seans;
import com.example.projekt2.repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    private Cinema findCinemaById(Long id) {
        return cinemaRepository.findById(id).orElseThrow(() -> new CinemaNotFoundException(id));
    }

    public Cinema getCinemaById(Long id) {
        return findCinemaById(id);
    }

    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    public void deleteCinemaById(Long id) {
        Cinema toDelete = findCinemaById(id);
        cinemaRepository.delete(toDelete);
    }
}

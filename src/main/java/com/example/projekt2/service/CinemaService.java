package com.example.projekt2.service;

import com.example.projekt2.exception.CinemaNotFoundException;
import com.example.projekt2.model.Cinema;
import com.example.projekt2.model.dto.write.CinemaWriteDto;
import com.example.projekt2.repository.CinemaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    public static final int PAGE_SIZE = 5;

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

    public List<Cinema> getAllCinemas(int page) {
        return cinemaRepository.findAllCinemas(PageRequest.of(page, PAGE_SIZE));
    }

    public void deleteCinemaById(Long id) {
        Cinema toDelete = findCinemaById(id);
        cinemaRepository.delete(toDelete);
    }

    public Cinema addCinema(CinemaWriteDto cinema) {
        Cinema newCinema = new Cinema();
        //pola
        return cinemaRepository.save(newCinema);
    }

    public Cinema editCinema(CinemaWriteDto cinema, Long id) {
        Cinema toEdit = findCinemaById(id);
        toEdit.setCity(cinema.city());
        toEdit.setName(cinema.name());
        toEdit.setNumber(cinema.number());
        toEdit.setStreet(cinema.street());
        //toEdit.setRooms(cinema.number());
        return cinemaRepository.save(toEdit);
    }
}

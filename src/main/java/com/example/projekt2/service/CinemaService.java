package com.example.projekt2.service;

import com.example.projekt2.exception.CinemaNotFoundException;
import com.example.projekt2.exception.RoomNotFoundException;
import com.example.projekt2.model.Cinema;
import com.example.projekt2.model.Room;
import com.example.projekt2.model.dto.write.CinemaWriteDto;
import com.example.projekt2.repository.CinemaRepository;
import com.example.projekt2.repository.RoomRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class CinemaService {

    public static final int PAGE_SIZE = 5;

    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;

    public CinemaService(CinemaRepository cinemaRepository, RoomRepository roomRepository) {
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
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

    @Transactional
    public Cinema addCinema(CinemaWriteDto cinema) {
        Cinema newCinema = new Cinema();
        newCinema.setName(cinema.name());
        newCinema.setCity(cinema.city());
        newCinema.setStreet(cinema.street());
        newCinema.setNumber(cinema.number());
        if (cinema.roomsIds().size() > 0) {
            setCinemaRooms(cinema, newCinema);
        }
        return cinemaRepository.save(newCinema);
    }

    @Transactional
    public Cinema editCinema(CinemaWriteDto cinema, Long id) {
        Cinema toEdit = findCinemaById(id);
        toEdit.setCity(cinema.city());
        toEdit.setName(cinema.name());
        toEdit.setNumber(cinema.number());
        toEdit.setStreet(cinema.street());

        if (cinema.roomsIds().size() > 0) {
            deleteCinemaRooms(toEdit);
            setCinemaRooms(cinema, toEdit);
        }
        return cinemaRepository.save(toEdit);
    }

    private void deleteCinemaRooms(Cinema toEdit) {
        Set<Room> copyRooms = Set.copyOf(toEdit.getRooms());
        copyRooms.forEach(toEdit::removeRoom);
    }

    private void setCinemaRooms(CinemaWriteDto cinema, Cinema toEdit) {
        cinema.roomsIds().forEach(roomId -> toEdit.addRoom(roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFoundException(roomId))));
    }
}

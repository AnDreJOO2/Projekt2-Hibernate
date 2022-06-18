package com.example.projekt2.service;

import com.example.projekt2.exception.FilmNotFoundException;
import com.example.projekt2.exception.RoomNotFoundException;
import com.example.projekt2.exception.SeansNotFoundException;
import com.example.projekt2.model.Film;
import com.example.projekt2.model.Room;
import com.example.projekt2.model.Seans;
import com.example.projekt2.model.dto.write.SeansWriteDto;
import com.example.projekt2.repository.FilmRepository;
import com.example.projekt2.repository.RoomRepository;
import com.example.projekt2.repository.SeansRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    public static final int PAGE_SIZE = 5;

    private final SeansRepository seansRepository;
    private final RoomRepository roomRepository;
    private final FilmRepository filmRepository;

    public ShowService(SeansRepository seansRepository, RoomRepository roomRepository, FilmRepository filmRepository) {
        this.seansRepository = seansRepository;
        this.roomRepository = roomRepository;
        this.filmRepository = filmRepository;
    }

    private Seans findShowById(Long id) {
        return seansRepository.findById(id).orElseThrow(() -> new SeansNotFoundException(id));
    }

    public Seans getShowById(Long id) {
        return findShowById(id);
    }

    public List<Seans> getAllShows(int page) {
        return seansRepository.findAllSeans(PageRequest.of(page, PAGE_SIZE));
    }

    public void deleteShowById(Long id) {
        Seans toDelete = findShowById(id);
        seansRepository.delete(toDelete);
    }

    public Seans addShow(SeansWriteDto seans) {
        Seans newSeans = new Seans();

        newSeans.setDateOfSeans(seans.dateOfSeans());
        newSeans.setStartTime(seans.startTime());
        newSeans.setLanguage(seans.language());
        if (seans.roomId() != null) {
            Room room = roomRepository.findById(seans.roomId()).orElseThrow(() -> new RoomNotFoundException(seans.roomId()));
            newSeans.setRoom(room);
        }
        if (seans.filmId() != null) {
            Film film = filmRepository.findById(seans.filmId()).orElseThrow(() -> new FilmNotFoundException(seans.filmId()));
            newSeans.setFilm(film);
        }

        return seansRepository.save(newSeans);
    }

    public Seans editShow(SeansWriteDto seans, Long id) {
        Seans toEdit = findShowById(id);
        toEdit.setDateOfSeans(seans.dateOfSeans());
        toEdit.setStartTime(seans.startTime());
        toEdit.setLanguage(seans.language());
        if (seans.roomId() != null) {
            toEdit.removeRoom(toEdit.getRoom());
            toEdit.setRoom(roomRepository.findById(seans.roomId()).orElseThrow(() -> new RoomNotFoundException(seans.roomId())));
        }
        if (seans.filmId() != null) {
            Film film = filmRepository.findById(seans.filmId()).orElseThrow(() -> new FilmNotFoundException(seans.filmId()));
            toEdit.setFilm(film);
        }
        return seansRepository.save(toEdit);
    }

}

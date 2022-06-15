package com.example.projekt2.service;

import com.example.projekt2.exception.FilmNotFoundException;
import com.example.projekt2.exception.RoomNotFoundException;
import com.example.projekt2.model.Film;
import com.example.projekt2.model.Room;
import com.example.projekt2.repository.FilmRepository;
import com.example.projekt2.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    private Room findRoomById(Long id){
        return roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

    public Room getRoomById(Long id){
        return findRoomById(id);
    }

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
}

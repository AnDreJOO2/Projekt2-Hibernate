package com.example.projekt2.service;

import com.example.projekt2.exception.RoomNotFoundException;
import com.example.projekt2.model.Film;
import com.example.projekt2.model.Room;
import com.example.projekt2.model.dto.write.RoomWriteDto;
import com.example.projekt2.repository.RoomRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    public static final int PAGE_SIZE = 5;
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    private Room findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

    public Room getRoomById(Long id) {
        return findRoomById(id);
    }

    public List<Room> getAllRooms(int page) {
        return roomRepository.findAllRooms(PageRequest.of(page, PAGE_SIZE));
    }

    public void deleteRoomById(Long id) {
        Room toDelete = findRoomById(id);
        roomRepository.delete(toDelete);
    }

    public Room addRoom(RoomWriteDto room) {
        Room newRoom = new Room();
        //pola
        return roomRepository.save(newRoom);
    }

    public Room editRoom(RoomWriteDto room, Long id) {
        Room toEdit = findRoomById(id);
        toEdit.setAirConditioning(room.airConditioning());
        toEdit.setPlaceNumber(room.placeNumber());
//        toEdit.setSeansSet(room.seansIds());
        return roomRepository.save(toEdit);
    }
}

package com.example.projekt2.service;

import com.example.projekt2.exception.RoomNotFoundException;
import com.example.projekt2.model.Room;
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

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room editRoom(Room room, Long id) {
        Room toEdit = findRoomById(id);
        toEdit.setAirConditioning(room.getAirConditioning());
        toEdit.setPlaceNumber(room.getPlaceNumber());
        toEdit.setSeansSet(room.getSeansSet());
        return roomRepository.save(toEdit);
    }
}

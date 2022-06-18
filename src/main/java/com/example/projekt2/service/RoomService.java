package com.example.projekt2.service;

import com.example.projekt2.exception.RoomNotFoundException;
import com.example.projekt2.exception.SeansNotFoundException;
import com.example.projekt2.model.Room;
import com.example.projekt2.model.Seans;
import com.example.projekt2.model.dto.write.RoomWriteDto;
import com.example.projekt2.repository.RoomRepository;
import com.example.projekt2.repository.SeansRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoomService {

    public static final int PAGE_SIZE = 5;
    private final RoomRepository roomRepository;
    private final SeansRepository seansRepository;

    public RoomService(RoomRepository roomRepository, SeansRepository seansRepository) {
        this.roomRepository = roomRepository;
        this.seansRepository = seansRepository;
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
        newRoom.setPlaceNumber(room.placeNumber());
        newRoom.setAirConditioning(room.airConditioning());
        if (room.seansIds().size() > 0) {
            setRoomSeanses(room, newRoom);
        }
        return roomRepository.save(newRoom);
    }

    public Room editRoom(RoomWriteDto room, Long id) {
        Room toEdit = findRoomById(id);
        toEdit.setAirConditioning(room.airConditioning());
        toEdit.setPlaceNumber(room.placeNumber());
        if (room.seansIds().size() > 0) {
            deleteRoomSeanses(toEdit);
            setRoomSeanses(room, toEdit);
        }
        return roomRepository.save(toEdit);
    }

    private void deleteRoomSeanses(Room toEdit) {
        Set<Seans> copySeanses = Set.copyOf(toEdit.getSeansSet());
        copySeanses.forEach(toEdit::removeSeans);
    }

    private void setRoomSeanses(RoomWriteDto room, Room toEdit) {
        room.seansIds().forEach(setId -> toEdit.addSeans(seansRepository.findById(setId).orElseThrow(() -> new SeansNotFoundException(setId))));
    }
}

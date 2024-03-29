package com.example.projekt2.controller;

import com.example.projekt2.model.Room;
import com.example.projekt2.model.dto.read.RoomReadDto;
import com.example.projekt2.model.dto.write.RoomWriteDto;
import com.example.projekt2.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.projekt2.model.mapper.RoomMapper.mapRoomListToRoomReadDtoList;
import static com.example.projekt2.model.mapper.RoomMapper.mapRoomToRoomDto;

@RestController
@RequestMapping("api")
public class RoomController {


    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping(value = "rooms", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<RoomReadDto>> getRooms(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int pageNumber = (page<1) ? 1 : page;
        return new ResponseEntity<>(mapRoomListToRoomReadDtoList(roomService.getAllRooms(pageNumber-1)), HttpStatus.OK);
    }

    @GetMapping(value = "rooms/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<RoomReadDto> getRoomById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapRoomToRoomDto().apply(roomService.getRoomById(id)), HttpStatus.OK);
    }

    @PostMapping(value = "rooms", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Room> addRoom(@Valid @RequestBody RoomWriteDto room) {
        return new ResponseEntity<>(roomService.addRoom(room), HttpStatus.CREATED);
    }

    @PutMapping(value = "rooms/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Room> editRoom(@PathVariable("id") Long id,@Valid @RequestBody RoomWriteDto room) {
        return new ResponseEntity<>(roomService.editRoom(room, id), HttpStatus.OK);
    }

    @DeleteMapping("rooms/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable("id") Long id) {
        roomService.deleteRoomById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
package com.example.projekt2.controller;

import com.example.projekt2.model.dto.RoomReadDto;
import com.example.projekt2.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping("rooms")
    public ResponseEntity<List<RoomReadDto>> getRooms() {
        return new ResponseEntity<>(mapRoomListToRoomReadDtoList(roomService.getAllRooms()), HttpStatus.OK);
    }

    @GetMapping("rooms/{id}")
    public ResponseEntity<RoomReadDto> getRoomById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapRoomToRoomDto().apply(roomService.getRoomById(id)), HttpStatus.OK);
    }

}
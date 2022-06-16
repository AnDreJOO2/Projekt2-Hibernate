package com.example.projekt2.controller;

import com.example.projekt2.model.dto.RoomReadDto;
import com.example.projekt2.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.projekt2.model.mapper.RoomMapper.mapRoomListToRoomReadDtoList;
import static com.example.projekt2.model.mapper.RoomMapper.mapRoomToRoomDto;

@RestController
@RequestMapping(value = "api", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class RoomController {


    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping("rooms")
    public ResponseEntity<List<RoomReadDto>> getRooms(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        int pageNumber = (page<1) ? 1 : page;
        return new ResponseEntity<>(mapRoomListToRoomReadDtoList(roomService.getAllRooms(pageNumber-1)), HttpStatus.OK);
    }

    @GetMapping("rooms/{id}")
    public ResponseEntity<RoomReadDto> getRoomById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapRoomToRoomDto().apply(roomService.getRoomById(id)), HttpStatus.OK);
    }

    @DeleteMapping("rooms/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable("id") Long id) {
        roomService.deleteRoomById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
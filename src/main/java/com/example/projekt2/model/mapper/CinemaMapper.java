package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Cinema;
import com.example.projekt2.model.dto.CinemaReadDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.projekt2.model.mapper.RoomMapper.mapRoomToRoomDto;

public class CinemaMapper {


    public static List<CinemaReadDto> mapCinemaListToCinemaReadDtoList(List<Cinema> cinemas) {
        return cinemas.stream().map(mapCinemaToCinemaReadDto()).collect(Collectors.toList());
    }

    public static Function<Cinema, CinemaReadDto> mapCinemaToCinemaReadDto() {
        return cinema -> new CinemaReadDto.CinemaReadDtoBuilder()
                .withName(cinema.getName())
                .withCity(cinema.getCity())
                .withStreet(cinema.getStreet())
                .withNumber(cinema.getNumber())
                .withRooms(cinema.getRooms().stream().map(
                        room -> mapRoomToRoomDto().apply(room)
                ).collect(Collectors.toSet()))
                .build();
    }
}

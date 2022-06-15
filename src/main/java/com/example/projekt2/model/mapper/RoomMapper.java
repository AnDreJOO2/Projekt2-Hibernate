package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Room;
import com.example.projekt2.model.dto.RoomReadDto;
import com.example.projekt2.model.dto.SeansReadDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.projekt2.model.mapper.FilmMapper.mapFilmToFilmReadDtoNoActorDirectorData;

public class RoomMapper {

    public static List<RoomReadDto> mapRoomListToRoomReadDtoList(List<Room> rooms) {
        return rooms.stream().map(mapRoomToRoomDto()).collect(Collectors.toList());
    }

    public static Function<Room, RoomReadDto> mapRoomToRoomDto() {
        return room -> new RoomReadDto.RoomReadDtoBuilder()
                .withPlaceNumber(room.getPlaceNumber())
                .withAirConditioning(room.getAirConditioning())
                .withSeansSet(room.getSeansSet().stream()
                        .map(seans -> new SeansReadDto.SeansReadDtoBuilder()
                                .withLanguage(seans.getLanguage())
                                .withDateOfSeans(seans.getDateOfSeans())
                                .withStartTime(seans.getStartTime())
                                .withFilm(mapFilmToFilmReadDtoNoActorDirectorData().apply(seans.getFilm())).build()
                        ).collect(Collectors.toSet()))
                .build();
    }
}

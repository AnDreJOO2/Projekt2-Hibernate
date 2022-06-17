package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Seans;
import com.example.projekt2.model.dto.read.SeansReadDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.projekt2.model.mapper.FilmMapper.mapFilmToFilmReadDto;
import static com.example.projekt2.model.mapper.RoomMapper.mapRoomToRoomDto;

public class ShowMapper {

    public static List<SeansReadDto> mapShowListToShowReadDtoList(List<Seans> shows) {
        return shows.stream().map(mapShowToShowsReadDto()).collect(Collectors.toList());
    }

    public static Function<Seans, SeansReadDto> mapShowToShowsReadDto() {
        return show -> new SeansReadDto.SeansReadDtoBuilder()
                .withId(show.getId())
                .withLanguage(show.getLanguage())
                .withDateOfSeans(show.getDateOfSeans())
                .withStartTime(show.getStartTime())
                .withLanguage(show.getLanguage())
                .withFilm(mapFilmToFilmReadDto().apply(show.getFilm()))
                .withRoom(mapRoomToRoomDto().apply(show.getRoom()))
                .build();
    }
}

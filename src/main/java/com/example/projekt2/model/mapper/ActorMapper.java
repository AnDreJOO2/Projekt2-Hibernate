package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Actor;
import com.example.projekt2.model.dto.ActorReadDto;
import com.example.projekt2.model.dto.FilmReadDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.projekt2.model.mapper.FilmMapper.mapFilmToFilmReadDtoNoActorDirectorData;

public class ActorMapper {

    public static List<ActorReadDto> mapActorListToActorDtoList(List<Actor> actors) {
        return actors.stream().map(mapActorToActorDto()).collect(Collectors.toList());
    }


    public static Function<Actor, ActorReadDto> mapActorToActorDto() {
        return actor -> new ActorReadDto.ActorReadDtoBuilder()
                .withName(actor.getName())
                .withSurname(actor.getSurname())
                .withAge(actor.getAge())
                .withFilms(actor.getFilms().stream()
                        .map(film -> mapFilmToFilmReadDtoNoActorDirectorData().apply(film)).collect(Collectors.toSet()))
                .build();
    }

}

package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Actor;
import com.example.projekt2.model.dto.ActorDto;
import com.example.projekt2.model.dto.DirectorReadDto;
import com.example.projekt2.model.dto.FilmReadDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.projekt2.model.mapper.DirectorMapper.*;

public class ActorMapper {

    public static List<ActorDto> mapActorListToActorDtoList(List<Actor> actors) {
        return actors.stream().map(mapActorToActorDto()).collect(Collectors.toList());
    }


    public static Function<Actor, ActorDto> mapActorToActorDto() {
        return actor -> new ActorDto.ActorDtoBuilder()
                .withId(actor.getId())
                .withName(actor.getName())
                .withSurname(actor.getSurname())
                .withAge(actor.getAge())
                .withFilms(actor.getFilms().stream()
                        .map(film -> new FilmReadDto.FilmReadDtoBuilder()
                                .withName(film.getName())
                                .withReleasedDate(film.getReleased())
                                .withMinutes(film.getMinutes())
                                .build()).collect(Collectors.toSet()))
                .build();
    }

}

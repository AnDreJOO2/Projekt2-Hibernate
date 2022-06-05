package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Actor;
import com.example.projekt2.model.dto.ActorDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ActorMapper {

    public static List<ActorDto> mapActorListToActorDtoList(List<Actor> actors) {
        return actors.stream().map(mapActorToActorDto()).collect(Collectors.toList());
    }


    public static Function<Actor, ActorDto> mapActorToActorDto() {
        return actor -> new ActorDto.ActorDtoBuilder()
                .withId(actor.getId())
                .build();
    }

}

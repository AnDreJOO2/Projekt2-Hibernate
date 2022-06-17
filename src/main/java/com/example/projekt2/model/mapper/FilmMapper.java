package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Film;
import com.example.projekt2.model.dto.read.ActorReadDto;
import com.example.projekt2.model.dto.read.FilmReadDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.example.projekt2.model.mapper.DirectorMapper.mapDirectorToDirectorReadDto;

public class FilmMapper {

    public static List<FilmReadDto> mapFilmListToFilmReadDtoList(List<Film> films) {
        return films.stream().map(mapFilmToFilmReadDtoNoActorDirectorData()).collect(Collectors.toList());
    }

    public static List<FilmReadDto> mapFilmListToFilmReadDtoListWithDetails(List<Film> films) {
        return films.stream().map(mapFilmToFilmReadDto()).collect(Collectors.toList());
    }

    public static Function<Film, FilmReadDto> mapFilmToFilmReadDto() {
        return film -> new FilmReadDto.FilmReadDtoBuilder()
                .withId(film.getId())
                .withReleasedDate(film.getReleased())
                .withMinutes(film.getMinutes())
                .withName(film.getName())
                .withActors(film.getActors().stream()
                        .map(actor -> new ActorReadDto.ActorReadDtoBuilder()
                                .withId(actor.getId())
                                .withName(actor.getName())
                                .withSurname(actor.getSurname())
                                .withAge(actor.getAge())
                                .build()
                        )
                        .collect(Collectors.toSet()))
                .withDirector(mapDirectorToDirectorReadDto().apply(film.getDirector()))
                .build();
    }

    public static Function<Film, FilmReadDto> mapFilmToFilmReadDtoNoActorDirectorData() {
        return film -> new FilmReadDto.FilmReadDtoBuilder()
                .withId(film.getId())
                .withReleasedDate(film.getReleased())
                .withMinutes(film.getMinutes())
                .withName(film.getName())
                .build();
    }
}

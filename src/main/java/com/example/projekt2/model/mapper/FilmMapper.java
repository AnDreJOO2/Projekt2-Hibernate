package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Film;
import com.example.projekt2.model.dto.FilmDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilmMapper {

    public static List<FilmDto> mapFilmListToFilmDtoList(List<Film> films){
        return films.stream().map(mapFilmToFilmDto()).collect(Collectors.toList());
    }

    public static Function<Film, FilmDto> mapFilmToFilmDto(){
        return film -> new FilmDto.FilmDtoBuilder()
                .withId(film.getId())
                .build();
    }
}

package com.example.projekt2.model.mapper;

import com.example.projekt2.model.Director;
import com.example.projekt2.model.dto.DirectorReadDto;
import com.example.projekt2.model.dto.FilmReadDto;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DirectorMapper {

    public static List<DirectorReadDto> getDirectorReadDtoList(List<Director> directors){
        return directors.stream().map(mapDirectorToDirectorReadDtoAll()).collect(Collectors.toList());
    }

    public static Function<Director, DirectorReadDto> mapDirectorToDirectorReadDto() {

        return director -> new DirectorReadDto.DirectorReadDtoBuilder()
                .withName(director.getName())
                .withSurname(director.getSurname())
                .withAge(director.getAge())
                .build();
    }

    public static Function<Director, DirectorReadDto> mapDirectorToDirectorReadDtoAll() {

        return director -> new DirectorReadDto.DirectorReadDtoBuilder()
                .withName(director.getName())
                .withSurname(director.getSurname())
                .withAge(director.getAge())
                .withFilms(director.getFilms().stream()
                        .map(film -> new FilmReadDto.FilmReadDtoBuilder()
                                .withName(film.getName())
                                .withMinutes(film.getMinutes())
                                .withReleasedDate(film.getReleased())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }
}

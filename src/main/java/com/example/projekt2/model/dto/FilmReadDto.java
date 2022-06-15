package com.example.projekt2.model.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class FilmReadDto {

    private final LocalDate released;


    private final Long minutes;
    private final String name;

    private final Set<ActorReadDto> actors;
    private final DirectorReadDto directorReadDto;

    private FilmReadDto(FilmReadDtoBuilder builder) {
        this.released = builder.released;
        this.actors = builder.actors;
        this.directorReadDto = builder.directorReadDto;
        this.minutes = builder.minutes;
        this.name = builder.name;
    }


    public LocalDate getReleased() {
        return released;
    }

    public Set<ActorReadDto> getActors() {
        return actors;
    }

    public DirectorReadDto getDirector() {
        return directorReadDto;
    }

    public Long getMinutes() {
        return minutes;
    }

    public String getName() {
        return name;
    }

    public static class FilmReadDtoBuilder {
        private LocalDate released;
        private Set<ActorReadDto> actors = new HashSet<>();
        private DirectorReadDto directorReadDto;
        private Long minutes;
        private String name;


        public FilmReadDtoBuilder withReleasedDate(LocalDate released) {
            this.released = released;
            return this;
        }

        public FilmReadDtoBuilder withActors(Set<ActorReadDto> actors) {
            this.actors = actors;
            return this;
        }

        public FilmReadDtoBuilder withDirector(DirectorReadDto directorReadDto) {
            this.directorReadDto = directorReadDto;
            return this;
        }

        public FilmReadDtoBuilder withMinutes(Long minutes) {
            this.minutes = minutes;
            return this;
        }

        public FilmReadDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FilmReadDto build() {
            return new FilmReadDto(this);
        }


    }
}

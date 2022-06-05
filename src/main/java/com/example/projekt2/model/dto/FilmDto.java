package com.example.projekt2.model.dto;

import com.example.projekt2.model.Actor;
import com.example.projekt2.model.Director;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class FilmDto {

    private Long id;
    private LocalDate released;
    private Set<Actor> actors = new HashSet<>();
    private Director director;
    private Long minutes;
    private String name;

    private FilmDto(FilmDtoBuilder builder) {
        this.id = builder.id;
        this.released = builder.released;
        this.actors = builder.actors;
        this.director = builder.director;
        this.minutes = builder.minutes;
        this.name = builder.name;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getReleased() {
        return released;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public Director getDirector() {
        return director;
    }

    public Long getMinutes() {
        return minutes;
    }

    public String getName() {
        return name;
    }

    public static class FilmDtoBuilder {
        private Long id;
        private LocalDate released;
        private Set<Actor> actors = new HashSet<>();
        private Director director;
        private Long minutes;
        private String name;

        public FilmDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public FilmDtoBuilder withReleasedDate(LocalDate released) {
            this.released = released;
            return this;
        }

        public FilmDtoBuilder withActors(Set<Actor> actors) {
            this.actors = actors;
            return this;
        }

        public FilmDtoBuilder withDirector(Director director) {
            this.director = director;
            return this;
        }

        public FilmDtoBuilder withMinutes(Long minutes) {
            this.minutes = minutes;
            return this;
        }

        public FilmDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public FilmDto build() {
            return new FilmDto(this);
        }


    }
}

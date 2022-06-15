package com.example.projekt2.model.dto;

import java.util.HashSet;
import java.util.Set;

public class ActorReadDto {

    private final Long id;

    private final String name;
    private final String surname;
    private final Integer age;

    private final Set<FilmReadDto> films;

    private ActorReadDto(ActorReadDtoBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
        this.films = builder.films;
    }

    public Long getId() {
        return id;
    }

    public Set<FilmReadDto> getFilms() {
        return films;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public static class ActorReadDtoBuilder {
        private Long id;

        private String name;
        private String surname;
        private Integer age;
        private Set<FilmReadDto> films = new HashSet<>();

        public ActorReadDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ActorReadDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ActorReadDtoBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public ActorReadDtoBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public ActorReadDtoBuilder withFilms(Set<FilmReadDto> films) {
            this.films = films;
            return this;
        }

        public ActorReadDto build() {
            return new ActorReadDto(this);
        }
    }
}

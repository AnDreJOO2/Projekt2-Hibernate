package com.example.projekt2.model.dto;

import java.util.HashSet;
import java.util.Set;

public class DirectorReadDto {

    private final Long id;

    private final Set<FilmReadDto> films;
    private final String name;
    private final String surname;
    private final Integer age;

    private DirectorReadDto(DirectorReadDtoBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.films = builder.films;
        this.surname = builder.surname;
        this.age = builder.age;
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

    public static class DirectorReadDtoBuilder {

        private Long id;

        private Set<FilmReadDto> films = new HashSet<>();
        private String name;
        private String surname;
        private Integer age;

        public DirectorReadDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }


        public DirectorReadDtoBuilder withFilms(Set<FilmReadDto> films) {
            this.films = films;
            return this;
        }

        public DirectorReadDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DirectorReadDtoBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public DirectorReadDtoBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public DirectorReadDto build() {
            return new DirectorReadDto(this);
        }
    }

}

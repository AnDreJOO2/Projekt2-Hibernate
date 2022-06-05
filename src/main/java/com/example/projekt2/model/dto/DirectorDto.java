package com.example.projekt2.model.dto;

import com.example.projekt2.model.Film;

import java.util.HashSet;
import java.util.Set;

public class DirectorDto {

    private Long id;
    private Set<Film> films = new HashSet<>();
    private String name;
    private String surname;
    private Integer age;

    private DirectorDto(DirectorDtoBuilder builder) {
        this.id = builder.id;
        this.films = builder.films;
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = builder.age;
    }

    public Long getId() {
        return id;
    }

    public Set<Film> getFilms() {
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

    private static class DirectorDtoBuilder {

        private Long id;
        private Set<Film> films = new HashSet<>();
        private String name;
        private String surname;
        private Integer age;

        public DirectorDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public DirectorDtoBuilder withFilms(Set<Film> films) {
            this.films = films;
            return this;
        }

        public DirectorDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DirectorDtoBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public DirectorDtoBuilder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public DirectorDto build() {
            return new DirectorDto(this);
        }
    }

}

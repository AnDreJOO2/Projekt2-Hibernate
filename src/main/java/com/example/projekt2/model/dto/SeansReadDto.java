package com.example.projekt2.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class SeansReadDto {


    private final String language;
    private final LocalDate dateOfSeans;
    private final LocalTime startTime;

    private final RoomReadDto room;
    private final FilmReadDto film;

    private SeansReadDto(SeansReadDtoBuilder builder) {
        this.language = builder.language;
        this.dateOfSeans = builder.dateOfSeans;
        this.startTime = builder.startTime;
        this.room = builder.room;
        this.film = builder.film;
    }


    public RoomReadDto getRoom() {
        return room;
    }

    public FilmReadDto getFilm() {
        return film;
    }

    public String getLanguage() {
        return language;
    }

    public LocalDate getDateOfSeans() {
        return dateOfSeans;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public static class SeansReadDtoBuilder {


        private String language;
        private LocalDate dateOfSeans;
        private LocalTime startTime;
        private RoomReadDto room;
        private FilmReadDto film;


        public SeansReadDtoBuilder withRoom(RoomReadDto room) {
            this.room = room;
            return this;
        }

        public SeansReadDtoBuilder withFilm(FilmReadDto film) {
            this.film = film;
            return this;
        }

        public SeansReadDtoBuilder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public SeansReadDtoBuilder withDateOfSeans(LocalDate dateOfSeans) {
            this.dateOfSeans = dateOfSeans;
            return this;
        }

        public SeansReadDtoBuilder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public SeansReadDto build() {
            return new SeansReadDto(this);
        }


    }
}

package com.example.projekt2.model.dto;

import com.example.projekt2.model.Film;
import com.example.projekt2.model.Room;

import java.time.LocalDate;
import java.time.LocalTime;

public class SeansDto {

    private Long id;
    private Room room;
    private Film film;
    private String language;
    private LocalDate dateOfSeans;
    private LocalTime startTime;

    private SeansDto(SeansDtoBuilder builder) {
        this.id = builder.id;
        this.room = builder.room;
        this.film = builder.film;
        this.language = builder.language;
        this.dateOfSeans = builder.dateOfSeans;
        this.startTime = builder.startTime;
    }

    public Long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Film getFilm() {
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

    public static class SeansDtoBuilder {

        private Long id;
        private Room room;
        private Film film;
        private String language;
        private LocalDate dateOfSeans;
        private LocalTime startTime;

        public SeansDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SeansDtoBuilder withRoom(Room room) {
            this.room = room;
            return this;
        }

        public SeansDtoBuilder withFilm(Film film) {
            this.film = film;
            return this;
        }

        public SeansDtoBuilder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public SeansDtoBuilder withDateOfSeans(LocalDate dateOfSeans) {
            this.dateOfSeans = dateOfSeans;
            return this;
        }

        public SeansDtoBuilder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public SeansDto build() {
            return new SeansDto(this);
        }


    }
}

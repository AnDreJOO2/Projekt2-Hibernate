package com.example.projekt2.model.dto;

import com.example.projekt2.model.Room;

import java.util.HashSet;
import java.util.Set;

public class CinemaDto {

    private Long id;
    private String name;
    private String city;
    private String street;
    private String number;
    private Set<Room> rooms = new HashSet<>();

    public CinemaDto(CinemaDtoBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.city = builder.city;
        this.street = builder.street;
        this.number = builder.number;
        this.rooms = builder.rooms;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public static class CinemaDtoBuilder {

        private Long id;
        private String name;
        private String city;
        private String street;
        private String number;
        private Set<Room> rooms = new HashSet<>();

        public CinemaDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CinemaDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CinemaDtoBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public CinemaDtoBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public CinemaDtoBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public CinemaDtoBuilder withRooms(Set<Room> rooms) {
            this.rooms = rooms;
            return this;
        }

        public CinemaDto build() {
            return new CinemaDto(this);
        }

    }
}

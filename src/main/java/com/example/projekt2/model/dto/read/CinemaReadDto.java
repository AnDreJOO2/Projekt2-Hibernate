package com.example.projekt2.model.dto.read;

import java.util.HashSet;
import java.util.Set;

public class CinemaReadDto {

    private final Long id;

    private final String name;
    private final String city;
    private final String street;
    private final String number;
    private final Set<RoomReadDto> rooms;

    public CinemaReadDto(CinemaReadDtoBuilder builder) {
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

    public Set<RoomReadDto> getRooms() {
        return rooms;
    }

    public static class CinemaReadDtoBuilder {

        private Long id;

        private String name;
        private String city;
        private String street;
        private String number;
        private Set<RoomReadDto> rooms = new HashSet<>();

        public CinemaReadDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CinemaReadDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CinemaReadDtoBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public CinemaReadDtoBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public CinemaReadDtoBuilder withNumber(String number) {
            this.number = number;
            return this;
        }

        public CinemaReadDtoBuilder withRooms(Set<RoomReadDto> rooms) {
            this.rooms = rooms;
            return this;
        }

        public CinemaReadDto build() {
            return new CinemaReadDto(this);
        }

    }
}

package com.example.projekt2.model.dto;

import com.example.projekt2.model.Seans;

import java.util.HashSet;
import java.util.Set;

public class RoomDto {

    private Long id;
    private Integer placeNumber;
    private Boolean airConditioning;
    private Set<Seans> seansSet = new HashSet<>();

    private RoomDto(RoomDtoBuilder builder) {
        this.id = builder.id;
        this.placeNumber = builder.placeNumber;
        this.airConditioning = builder.airConditioning;
        this.seansSet = builder.seansSet;
    }

    public Long getId() {
        return id;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public Set<Seans> getSeansSet() {
        return seansSet;
    }

    public static class RoomDtoBuilder {

        private Long id;
        private Integer placeNumber;
        private Boolean airConditioning;
        private Set<Seans> seansSet = new HashSet<>();

        public RoomDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public RoomDtoBuilder withPlaceNumber(Integer placeNumber) {
            this.placeNumber = placeNumber;
            return this;
        }

        public RoomDtoBuilder withAirConditioning(Boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }

        public RoomDtoBuilder withId(Set<Seans> seansSet) {
            this.seansSet = seansSet;
            return this;
        }

        public RoomDto build() {
            return new RoomDto(this);
        }
    }
}

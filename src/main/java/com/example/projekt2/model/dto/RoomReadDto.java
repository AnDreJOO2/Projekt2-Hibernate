package com.example.projekt2.model.dto;

import java.util.HashSet;
import java.util.Set;

public class RoomReadDto {

    private final Long id;
    private final Integer placeNumber;
    private final Boolean airConditioning;
    private final Set<SeansReadDto> seansSet;

    private RoomReadDto(RoomReadDtoBuilder builder) {
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

    public Set<SeansReadDto> getSeansSet() {
        return seansSet;
    }

    public static class RoomReadDtoBuilder {

        private Long id;
        private Integer placeNumber;
        private Boolean airConditioning;
        private Set<SeansReadDto> seansSet = new HashSet<>();

        public RoomReadDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public RoomReadDtoBuilder withPlaceNumber(Integer placeNumber) {
            this.placeNumber = placeNumber;
            return this;
        }

        public RoomReadDtoBuilder withAirConditioning(Boolean airConditioning) {
            this.airConditioning = airConditioning;
            return this;
        }

        public RoomReadDtoBuilder withSeansSet(Set<SeansReadDto> seansSet) {
            this.seansSet = seansSet;
            return this;
        }

        public RoomReadDto build() {
            return new RoomReadDto(this);
        }
    }
}

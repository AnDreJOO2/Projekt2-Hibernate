package com.example.projekt2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer placeNumber;
    private Boolean airConditioning;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "room")
    private Set<Seans> seansSet = new HashSet<>();

    public void addSeans(Seans seans) {
        this.getSeansSet().add(seans);
        seans.setRoom(this);
    }

    public void removeSeans(Seans seans) {
        this.getSeansSet().remove(seans);
        seans.setRoom(null);
    }


    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }

    public Boolean getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Set<Seans> getSeansSet() {
        return seansSet;
    }

    public void setSeansSet(Set<Seans> seansSet) {
        this.seansSet = seansSet;
    }
}

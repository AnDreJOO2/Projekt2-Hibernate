package com.example.projekt2.repository;

import com.example.projekt2.model.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r from Room r")
    List<Room> findAllRooms(Pageable page);
}

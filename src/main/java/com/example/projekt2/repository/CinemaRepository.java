package com.example.projekt2.repository;

import com.example.projekt2.model.Cinema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    @Query("SELECT c FROM Cinema c")
    List<Cinema> findAllCinemas(Pageable page);
}

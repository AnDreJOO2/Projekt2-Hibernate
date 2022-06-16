package com.example.projekt2.repository;

import com.example.projekt2.model.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {


    @Query("SELECT f FROM Film f")
     List<Film> findAllFilms(Pageable page);
}

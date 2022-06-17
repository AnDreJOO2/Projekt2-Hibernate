package com.example.projekt2.repository;

import com.example.projekt2.model.Director;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    @Query("SELECT d FROM Director d")
    List<Director> findAllDirectors(Pageable page);
}

package com.example.projekt2.repository;

import com.example.projekt2.model.Seans;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeansRepository extends JpaRepository<Seans, Long> {

    @Query("SELECT s from Seans s")
    List<Seans> findAllSeans(Pageable page);
}

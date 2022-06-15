package com.example.projekt2.repository;

import com.example.projekt2.model.Seans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeansRepository extends JpaRepository<Seans,Long> {
}

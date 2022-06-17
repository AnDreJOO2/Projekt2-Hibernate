package com.example.projekt2.repository;

import com.example.projekt2.model.Actor;
import com.example.projekt2.model.Film;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a where  a.age >= :olderThan")
    List<Actor> findAllActors(Pageable page, @Param("olderThan") int olderThan);

    @Query("SELECT a.films FROM Actor a WHERE a = :actor")
    List<Film> findAllActorFilms(@Param("actor") Actor actor);
}

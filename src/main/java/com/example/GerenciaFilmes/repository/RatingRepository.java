package com.example.GerenciaFilmes.repository;

import com.example.GerenciaFilmes.model.Movie;
import com.example.GerenciaFilmes.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByMovie(Movie movie);
    List<Rating> findByUserId(Long userid);
}


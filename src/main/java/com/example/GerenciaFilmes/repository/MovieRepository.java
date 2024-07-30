package com.example.GerenciaFilmes.repository;

import com.example.GerenciaFilmes.model.Category;
import com.example.GerenciaFilmes.model.Genre;
import com.example.GerenciaFilmes.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByCategory(Category category);
    List<Movie> findByGenresContaining(Genre genre);
}

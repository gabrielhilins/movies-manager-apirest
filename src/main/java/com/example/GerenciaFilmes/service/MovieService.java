package com.example.GerenciaFilmes.service;

import com.example.GerenciaFilmes.exceptions.ResourceNotFoundException;
import com.example.GerenciaFilmes.model.Category;
import com.example.GerenciaFilmes.model.Genre;
import com.example.GerenciaFilmes.model.Movie;
import com.example.GerenciaFilmes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    public Movie updateMovie(Long id, Movie movie) {
        Movie existingMovie = getMovieById(id);
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setReleaseYear(movie.getReleaseYear());
        existingMovie.setSinopse(movie.getSinopse());
        existingMovie.setGenres(movie.getGenres());
        existingMovie.setCategory(movie.getCategory());
        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> searchMovies(String title) {
        return movieRepository.findByTitleContaining(title);
    }

    public List<Movie> filterMoviesByCategory(Category category) {
        return movieRepository.findByCategory(category);
    }

    public List<Movie> filterMoviesByGenre(Genre genre) {
        return movieRepository.findByGenresContaining(genre);
    }
}


package com.example.GerenciaFilmes.service;

import com.example.GerenciaFilmes.exceptions.ResourceNotFoundException;
import com.example.GerenciaFilmes.model.Movie;
import com.example.GerenciaFilmes.model.Rating;
import com.example.GerenciaFilmes.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

    // Create
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // Read
    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found with id: " + id));
    }

    public List<Rating> getRatingsForMovie(Movie movie) {
        return ratingRepository.findByMovie(movie);
    }

    public List<Rating> getRatingsByUser(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    // Update
    public Rating updateRating(Long id, Rating updatedRating) {
        Rating existingRating = ratingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found with id: " + id));

        existingRating.setRating(updatedRating.getRating());
        existingRating.setReview(updatedRating.getReview());

        return ratingRepository.save(existingRating);
    }

    // Delete
    public void deleteRating(Long id) {
        Rating existingRating = ratingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rating not found with id: " + id));
        ratingRepository.delete(existingRating);
    }
}
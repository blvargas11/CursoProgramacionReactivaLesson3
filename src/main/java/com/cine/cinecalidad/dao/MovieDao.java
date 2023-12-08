package com.cine.cinecalidad.dao;

import com.cine.cinecalidad.models.Movie;
import com.cine.cinecalidad.models.MovieRating;


public interface MovieDao {

    Movie getMovieById(String movieId);

    MovieRating movieRating(String movieId, int rating);

}

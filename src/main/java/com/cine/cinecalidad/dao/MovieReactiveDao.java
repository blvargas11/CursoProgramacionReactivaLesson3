package com.cine.cinecalidad.dao;

import com.cine.cinecalidad.models.Movie;
import com.cine.cinecalidad.models.MovieRating;
import reactor.core.publisher.Mono;

public interface MovieReactiveDao {

    Mono<Movie> getMovieByIdReactive(String movieId);

    Mono<MovieRating> movieRatingReactive(String movieId, int rating);

}

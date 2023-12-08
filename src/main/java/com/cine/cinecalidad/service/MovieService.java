package com.cine.cinecalidad.service;

import com.cine.cinecalidad.dao.MovieDao;
import com.cine.cinecalidad.dao.MovieReactiveDao;
import com.cine.cinecalidad.models.Movie;
import com.cine.cinecalidad.models.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

    @Autowired
    private MovieReactiveDao movieReactiveDao;

    public Mono<Movie> getMovieByIdReactive(String movieId) {
        return movieReactiveDao.getMovieByIdReactive(movieId);
    }

    public Mono<MovieRating> movieRatingReactive(String movieId, int rating){
        return movieReactiveDao.movieRatingReactive(movieId, rating);
    }


}

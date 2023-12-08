package com.cine.cinecalidad.controllers;

import com.cine.cinecalidad.dao.MovieDao;
import com.cine.cinecalidad.models.Movie;
import com.cine.cinecalidad.models.MovieRating;
import com.cine.cinecalidad.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieReactiveControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieReactiveController movieReactiveController;

    @Test
    public void testGetMovieByIdReactive(){
        String movieID = "tt0232500";
        Movie mockMovie = new Movie();
        mockMovie.setImdbID(movieID);
        mockMovie.setTitle("Rapidos y Furiosos");


        when(movieService.getMovieByIdReactive(movieID)).thenReturn(Mono.just(mockMovie));
        Mono<Movie> result = movieReactiveController.getMovieByIdReactive(movieID);
        verify(movieService, times(1)).getMovieByIdReactive(movieID);
        assertNotNull(result, "Result should not be null");
        assertEquals(mockMovie, result.block());

    }

    @Test
    public void testMovieRatingReactive() {

        String movieID = "tt0232500";
        int rating = 5;
        MovieRating mockMovieRating = new MovieRating();
        mockMovieRating.setImdbID(movieID);
        mockMovieRating.setRatings(rating);


        when(movieService.movieRatingReactive(movieID, rating)).thenReturn(Mono.just(mockMovieRating));
        Mono<MovieRating> result = movieReactiveController.movieRatingReactive(movieID, rating);
        verify(movieService, times(1)).movieRatingReactive(movieID, rating);
        assertNotNull(result, "Result should not be null");
        assertEquals(mockMovieRating, result.block());
    }
}
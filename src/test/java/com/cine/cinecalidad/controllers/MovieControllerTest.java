package com.cine.cinecalidad.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.cine.cinecalidad.dao.MovieDao;
import com.cine.cinecalidad.models.Movie;
import com.cine.cinecalidad.models.MovieRating;
import com.cine.cinecalidad.service.MovieService;
import com.sun.jdi.event.StepEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    @Mock
    private MovieDao movieDao;

    @InjectMocks
    private MovieController movieController;

    @Test
    public void testGetMovieById() {

        String movieID = "tt0232500";
        Movie mockMovie = new Movie();
        mockMovie.setImdbID(movieID);
        mockMovie.setTitle("Rapidos y Furiosos");

        when(movieDao.getMovieById(movieID)).thenReturn(mockMovie);
        Movie result = movieController.getMovieById(movieID);
        verify(movieDao, times(1)).getMovieById(movieID);
        assertEquals(mockMovie, result);
    }

    @Test
    public void testMovieRating() {

        String movieID = "tt0232500";
        int rating = 5;
        MovieRating mockMovieRating = new MovieRating();
        mockMovieRating.setImdbID(movieID);
        mockMovieRating.setRatings(rating);


        when(movieDao.movieRating(movieID, rating)).thenReturn(mockMovieRating);
        MovieRating result = movieController.movieRating(movieID, rating);
        verify(movieDao, times(1)).movieRating(movieID, rating);
        assertEquals(mockMovieRating, result);
    }

}

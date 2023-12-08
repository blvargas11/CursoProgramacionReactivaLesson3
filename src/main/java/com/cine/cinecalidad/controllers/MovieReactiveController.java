package com.cine.cinecalidad.controllers;

import com.cine.cinecalidad.dao.MovieDao;
import com.cine.cinecalidad.models.Movie;
import com.cine.cinecalidad.models.MovieRating;
import com.cine.cinecalidad.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MovieReactiveController {

    @Autowired
    private MovieService movieService;


    //Un endpoint el cual sus clientes (visitantes del cine) pueden obtener los detalles acerca de una de sus películas
    //(por ejemplo nombre, descripción, fecha de lanzamiento, puntuación, puntuación IMDb, y proyección).
    //Aunque hay una oferta limitada, por favor use las APIs OMDB
    //(detallada abajo) para demostrar cómo se comunican a través de APIs.
    //http://localhost:8080/api/reactive/movie/tt0232500
    @GetMapping("api/reactive/movie/{movieID}")
    public Mono<Movie> getMovieByIdReactive(@PathVariable String movieID) {
        return movieService.getMovieByIdReactive(movieID);
    }

    //Un endpoint en el cual sus clientes (visitantes del cine) pueden dejar una calificación
    // (de 1-5 estrellas) acerca de una película en particular
    //http://localhost:8080/api/reactive/movie/tt0232500/5
    @GetMapping("api/reactive/movie/{movieID}/{rating}")
    public Mono<MovieRating> movieRatingReactive(@PathVariable String movieID, @PathVariable int rating) {
        return movieService.movieRatingReactive(movieID, rating);
    }
}

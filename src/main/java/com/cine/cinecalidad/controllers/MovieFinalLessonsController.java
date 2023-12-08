package com.cine.cinecalidad.controllers;

import com.cine.cinecalidad.exceptions.MovieServiceException;
import com.cine.cinecalidad.models.MovieFinalLessons;
import com.cine.cinecalidad.service.MovieFinalLessonService;
import com.cine.cinecalidad.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class MovieFinalLessonsController {

    @Autowired
    private MovieFinalLessonService movieFinalLessonService;

    //Obtener todas las películas sin algún orden
    //http://localhost:8080/api/final/movies
    @RequestMapping(value = "api/final/movies", method = RequestMethod.GET)
    public Mono<List<MovieFinalLessons>> getUsuario() {
        return movieFinalLessonService.getMoviesFinalLesson()
                .onErrorMap(ex -> new MovieServiceException("Error al obtener la lista de películas", ex));
    }

    //Ordenar por rating de forma ascendente:
    //http://localhost:8080/api/final/movies/order-by?sort=rating

    //Ordenar por name de forma ascendente y luego por rating de forma descendente:
    //http://localhost:8080/api/final/movies/order-by?sort=name,-rating

    //Ordenar por releaseDate de forma descendente:
    //http://localhost:8080/api/final/movies/order-by?sort=-releaseDate
    @GetMapping("api/final/movies/order-by")
    public Mono<List<MovieFinalLessons>> getMoviesOrderedBy(
            @RequestParam(name = "sort", required = false) List<String> sortFields) {
        return movieFinalLessonService.getMoviesOrderedBy(sortFields);
    }

}

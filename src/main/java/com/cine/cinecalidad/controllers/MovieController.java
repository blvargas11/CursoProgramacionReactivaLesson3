package com.cine.cinecalidad.controllers;

import com.cine.cinecalidad.dao.MovieDao;
import com.cine.cinecalidad.models.Movie;
import com.cine.cinecalidad.models.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MovieController {

    @Autowired
    private MovieDao movieDao;


    //Un endpoint el cual sus clientes (visitantes del cine) pueden obtener los detalles acerca de una de sus películas
    //(por ejemplo nombre, descripción, fecha de lanzamiento, puntuación, puntuación IMDb, y proyección).
    //Aunque hay una oferta limitada, por favor use las APIs OMDB
    //(detallada abajo) para demostrar cómo se comunican a través de APIs.

    //Para consultar http://localhost:8080/api/movie/tt0232500
    @RequestMapping(value = "api/movie/{movieID}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable String movieID) {
        return movieDao.getMovieById(movieID);
    }


    //Un endpoint en el cual sus clientes (visitantes del cine) pueden dejar una calificación
    // (de 1-5 estrellas) acerca de una película en particular

    //http://localhost:8080/api/movie/tt0232500/(Valor de 1 a 5)
    @RequestMapping(value = "api/movie/{movieID}/{rating}", method = RequestMethod.GET)
    public MovieRating movieRating(@PathVariable String movieID, @PathVariable int rating) {
        return movieDao.movieRating(movieID, rating);
    }


}

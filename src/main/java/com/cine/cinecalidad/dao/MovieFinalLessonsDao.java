package com.cine.cinecalidad.dao;


import com.cine.cinecalidad.models.MovieFinalLessons;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MovieFinalLessonsDao {

    Mono<List<MovieFinalLessons>> getMoviesFinalLesson();

    Mono<List<MovieFinalLessons>> getMoviesOrderedBy(List<String> sortFields);

}

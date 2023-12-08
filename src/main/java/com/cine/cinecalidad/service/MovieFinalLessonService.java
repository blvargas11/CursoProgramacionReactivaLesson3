package com.cine.cinecalidad.service;

import com.cine.cinecalidad.dao.MovieFinalLessonsDao;
import com.cine.cinecalidad.models.MovieFinalLessons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MovieFinalLessonService {

    @Autowired
    private MovieFinalLessonsDao movieFinalLessonsDao;

    public Mono<List<MovieFinalLessons>> getMoviesFinalLesson() {
        return movieFinalLessonsDao.getMoviesFinalLesson();
    }

    public Mono<List<MovieFinalLessons>> getMoviesOrderedBy(List<String> sortFields) {
        return movieFinalLessonsDao.getMoviesOrderedBy(sortFields);
    }

}

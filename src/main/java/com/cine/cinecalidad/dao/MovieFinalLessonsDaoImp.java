package com.cine.cinecalidad.dao;

import com.cine.cinecalidad.exceptions.MovieServiceException;
import com.cine.cinecalidad.models.MovieFinalLessons;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class MovieFinalLessonsDaoImp implements MovieFinalLessonsDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Mono<List<MovieFinalLessons>> getMoviesFinalLesson() {
        try {
            String query = "FROM MovieFinalLessons";
            List<MovieFinalLessons> resultList = entityManager.createQuery(query, MovieFinalLessons.class).getResultList();
            return Mono.just(resultList);
        } catch (Exception e) {
            throw new MovieServiceException("Error al obtener la lista de películas", e);
        }
    }

    @Override
    public Mono<List<MovieFinalLessons>> getMoviesOrderedBy(List<String> sortFields) {
        try {
            String query = "FROM MovieFinalLessons m ORDER BY";
            if (sortFields != null && !sortFields.isEmpty()) {
                query += " " + buildOrderByClause(sortFields);
            }
            List<MovieFinalLessons> resultList = entityManager.createQuery(query, MovieFinalLessons.class).getResultList();
            return Mono.just(resultList);
        } catch (Exception e) {
            throw new MovieServiceException("Error al obtener la lista de películas ordenadas", e);
        }
    }

    private String buildOrderByClause(List<String> sortFields) {
        return sortFields.stream()
                .map(field -> {
                    if (field.startsWith("-")) {
                        return field.substring(1) + " DESC";
                    } else {
                        return field;
                    }
                })
                .collect(Collectors.joining(", "));
    }


}

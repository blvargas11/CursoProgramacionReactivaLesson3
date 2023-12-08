package com.cine.cinecalidad.controllers;

import com.cine.cinecalidad.models.MovieFinalLessons;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieFinalLessonsControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGetMoviesFinalLesson() {
        webTestClient.get()
                .uri("/api/final/movies")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(MovieFinalLessons.class)
                .consumeWith(response -> {
                    List<MovieFinalLessons> movies = response.getResponseBody();
                    assert movies != null && !movies.isEmpty();
                });
    }

    @Test
    public void testGetMoviesOrderedBy() {
        webTestClient.get()
                .uri("/api/final/movies/order-by?sort=rating&sort=-releaseDate")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(MovieFinalLessons.class)
                .consumeWith(response -> {
                    List<MovieFinalLessons> movies = response.getResponseBody();

                    // Verifica que la lista no sea nula y tenga al menos un elemento
                    assert movies != null && !movies.isEmpty();

                    //Las películas estén ordenadas por rating de forma ascendente
                    for (int i = 1; i < movies.size(); i++) {
                        assert movies.get(i - 1).getRating() <= movies.get(i).getRating();
                    }
                });
    }
}
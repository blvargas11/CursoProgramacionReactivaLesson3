package com.cine.cinecalidad.dao;

import com.cine.cinecalidad.exceptions.MovieServiceException;
import com.cine.cinecalidad.models.Movie;
import com.cine.cinecalidad.models.MovieRating;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
@Transactional
public class MovieReactiveDaoImp implements MovieReactiveDao {

    private static final String API_KEY = "9e160a8c";
    private static final String API_URL = "http://www.omdbapi.com/";

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Mono<Movie> getMovieByIdReactive(String movieId) {
        return Mono.fromCallable(() -> {
            HttpClient client = HttpClient.newHttpClient();
            String url = API_URL + "?apikey=" + API_KEY + "&i=" + movieId;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                JSONObject jsonMovie = new JSONObject(response.body());
                Movie movie = new Movie();
                movie.setImdbID(jsonMovie.getString("imdbID"));
                movie.setTitle(jsonMovie.getString("Title"));
                movie.setYear(jsonMovie.getInt("Year"));
                movie.setRated(jsonMovie.getString("Rated"));
                movie.setReleased(jsonMovie.getString("Released"));
                //movie.setRuntime(jsonMovie.getString("Runtime"));
                movie.setGenre(jsonMovie.getString("Genre"));
                movie.setDirector(jsonMovie.getString("Director"));
                movie.setWriter(jsonMovie.getString("Writer"));
                movie.setActors(jsonMovie.getString("Actors"));
                movie.setPlot(jsonMovie.getString("Plot"));
                movie.setLanguage(jsonMovie.getString("Language"));
                movie.setCountry(jsonMovie.getString("Country"));
                movie.setAwards(jsonMovie.getString("Awards"));
                movie.setPoster(jsonMovie.getString("Poster"));
                movie.setMetascore(jsonMovie.getInt("Metascore"));
                //movie.setImdbRating(jsonMovie.getInt("imdbRating"));
                movie.setImdbVotes(jsonMovie.getString("imdbVotes"));
                movie.setType(jsonMovie.getString("Type"));
                movie.setDvd(jsonMovie.getString("DVD"));
                movie.setBoxOffice(jsonMovie.getString("BoxOffice"));
                movie.setProduction(jsonMovie.getString("Production"));
                movie.setWebsite(jsonMovie.getString("Website"));
                movie.setResponse(jsonMovie.getBoolean("Response"));

                return movie;
            } catch (Exception e) {
                throw new MovieServiceException("Error al obtener la película desde OMDB", e);
            }
        });
    }

    @Override
    public Mono<MovieRating> movieRatingReactive(String movieId, int rating) {
        return Mono.fromCallable(() -> {
            HttpClient client = HttpClient.newHttpClient();
            String url = API_URL + "?apikey=" + API_KEY + "&i=" + movieId;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                JSONObject jsonMovie = new JSONObject(response.body());
                MovieRating movieRating = new MovieRating();
                movieRating.setImdbID(jsonMovie.getString("imdbID"));
                movieRating.setTitle(jsonMovie.getString("Title"));
                movieRating.setYear(jsonMovie.getInt("Year"));
                movieRating.setRated(jsonMovie.getString("Rated"));
                movieRating.setReleased(jsonMovie.getString("Released"));
                movieRating.setRatings(rating);


                return movieRating;
            } catch (Exception e) {
                throw new MovieServiceException("Error al obtener la película desde OMDB", e);
            }
        });
    }
}

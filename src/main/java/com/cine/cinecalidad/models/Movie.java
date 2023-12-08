package com.cine.cinecalidad.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Getter
    @Setter
    @Column(name = "imdbID")
    private String imdbID;

    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    @Getter
    @Setter
    @Column(name = "year")
    private int year;

    @Getter
    @Setter
    @Column(name = "rated")
    private String rated;

    @Getter
    @Setter
    @Column(name = "released")
    private String released;

    @Getter
    @Setter
    @Column(name = "runtime")
    private int runtime;

    @Getter
    @Setter
    @Column(name = "genre")
    private String genre;

    @Getter
    @Setter
    @Column(name = "director")
    private String director;

    @Getter
    @Setter
    @Column(name = "writer")
    private String writer;

    @Getter
    @Setter
    @Column(name = "actors")
    private String actors;

    @Getter
    @Setter
    @Column(name = "plot")
    private String plot;

    @Getter
    @Setter
    @Column(name = "language")
    private String language;

    @Getter
    @Setter
    @Column(name = "country")
    private String country;

    @Getter
    @Setter
    @Column(name = "awards")
    private String awards;

    @Getter
    @Setter
    @Column(name = "poster")
    private String poster;

    @Getter
    @Setter
    @Column(name = "ratings")
    private int ratings;

    @Getter
    @Setter
    @Column(name = "metascore")
    private int metascore;

    @Getter
    @Setter
    @Column(name = "imdbRating")
    private double imdbRating;

    @Getter
    @Setter
    @Column(name = "imdbVotes")
    private String imdbVotes;

    @Getter
    @Setter
    @Column(name = "type")
    private String type;

    @Getter
    @Setter
    @Column(name = "dvd")
    private String dvd;

    @Getter
    @Setter
    @Column(name = "boxOffice")
    private String boxOffice;

    @Getter
    @Setter
    @Column(name = "production")
    private String production;

    @Getter
    @Setter
    @Column(name = "website")
    private String website;

    @Getter
    @Setter
    @Column(name = "response")
    private boolean response;

}



package com.cine.cinecalidad.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieFinalLessons {

    @Id
    @Getter
    @Setter
    @Column(name = "imdbID")
    private String imdbID;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "releaseDate")
    private String releaseDate;

    @Getter
    @Setter
    @Column(name = "rating")
    private double rating;

    @Getter
    @Setter
    @Column(name = "runtime")
    private String runtime;

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
}

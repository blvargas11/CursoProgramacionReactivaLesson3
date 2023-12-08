package com.cine.cinecalidad.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class MovieRating {
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
    @Column(name = "ratings")
    private int ratings;



}

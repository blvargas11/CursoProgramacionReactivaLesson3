//CREATE DATABASE MOVIES;
//USE peliculas;

CREATE TABLE Movies (
    imdbID VARCHAR(255),
    name VARCHAR(255),
    releaseDate VARCHAR(255),
    rating DECIMAL(3,1),
    Runtime VARCHAR(255),
    Genre VARCHAR(255),
    Director VARCHAR(255),
    Writer VARCHAR(255),
    Actors VARCHAR(255),
    Plot TEXT,
    PRIMARY KEY (imdbID)
);

INSERT INTO Pelicula VALUES
('tt001', 'The Silent Movie', '1920-05-15', 7.8, '90 minutos', 'Silent', 'Director A', 'Writer X', 'Actor1, Actor2', 'Una película muda increíble.'),
('tt002', 'Epic Adventure', '2005-12-20', 9.2, '150 minutos', 'Aventura', 'Director B', 'Writer Y', 'Actor3, Actor4', 'Una increíble aventura épica.'),
('tt003', 'Comedy Fiesta', '1998-08-10', 6.5, '120 minutos', 'Comedia', 'Director C', 'Writer Z', 'Actor5, Actor6', '¡La comedia más divertida de la década!'),
('tt004', 'Sci-Fi Spectacle', '2010-03-25', 8.0, '135 minutos', 'Ciencia ficción', 'Director D', 'Writer W', 'Actor7, Actor8', 'Un espectáculo de ciencia ficción que desafía la mente.'),
('tt005', 'Romantic Bliss', '2015-02-14', 7.9, '110 minutos', 'Romance', 'Director E', 'Writer V', 'Actor9, Actor10', 'Una historia de amor que te robará el corazón.'),
('tt006', 'Mystery Mansion', '2008-09-30', 6.8, '140 minutos', 'Misterio', 'Director F', 'Writer U', 'Actor11, Actor12', 'Un misterio intrigante en una mansión ancestral.'),
('tt007', 'Action Showdown', '2019-06-05', 8.7, '105 minutos', 'Acción', 'Director G', 'Writer T', 'Actor13, Actor14', 'La acción alcanza su punto máximo en este enfrentamiento emocionante.'),
('tt008', 'Fantasy World', '2013-11-18', 8.4, '125 minutos', 'Fantasía', 'Director H', 'Writer S', 'Actor15, Actor16', 'Adéntrate en un mundo de fantasía nunca antes visto.'),
('tt009', 'Historical Drama', '2000-04-12', 7.6, '130 minutos', 'Drama histórico', 'Director I', 'Writer R', 'Actor17, Actor18', 'Un drama histórico que te transportará al pasado.'),
('tt010', 'Thriller Heights', '2017-08-08', 9.0, '95 minutos', 'Suspenso', 'Director J', 'Writer Q', 'Actor19, Actor20', 'Un thriller que te mantendrá al borde de tu asiento.');

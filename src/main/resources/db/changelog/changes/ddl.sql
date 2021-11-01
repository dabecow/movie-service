--liquibase formatted sql

--changeset Andrei:1

CREATE TABLE IF NOT EXISTS movies.movie (
  movie_id BIGSERIAL NOT NULL,
  movie_title VARCHAR(45) NOT NULL,
  description VARCHAR(255),
  release_date TIMESTAMP(6),
  PRIMARY KEY (movie_id))
;

CREATE TABLE IF NOT EXISTS movie_service.actor (
  actor_id BIGSERIAL NOT NULL,
  actor_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (actor_id),
  UNIQUE(actor_name))
;

CREATE TABLE IF NOT EXISTS movie_service.genre (
  genre_id BIGSERIAL NOT NULL,
  genre_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (genre_id),
  UNIQUE(genre_name))
;

CREATE TABLE IF NOT EXISTS movie_service.movie_genre (
  movie_id BIGINT NOT NULL REFERENCES movie(movie_id),
  genre_id BIGINT NOT NULL REFERENCES genre(genre_id),
  PRIMARY KEY (movie_id, genre_id)
);

CREATE TABLE IF NOT EXISTS movie_service.movie_actor (
  movie_id BIGINT NOT NULL REFERENCES movie(movie_id),
  actor_id BIGINT NOT NULL REFERENCES actor(actor_id),
  PRIMARY KEY (movie_id, actor_id)
);
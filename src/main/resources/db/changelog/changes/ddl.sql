--liquibase formatted sql

--changeset Andrei:2

CREATE SCHEMA IF NOT EXISTS movie_service;
SET SCHEMA 'movie_service' ;

CREATE TABLE IF NOT EXISTS movie_service.Movie (
  movie_id BIGSERIAL NOT NULL,
  movie_title VARCHAR(45) NOT NULL,
  description VARCHAR(255),
  release_date TIMESTAMP(6),
  PRIMARY KEY (movie_id))
;

CREATE TABLE IF NOT EXISTS movie_service.Actor (
  actor_id BIGSERIAL NOT NULL,
  actor_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (actor_id),
  UNIQUE(actor_name))
;

CREATE TABLE IF NOT EXISTS movie_service.Genre (
  genre_id BIGSERIAL NOT NULL,
  genre_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (genre_id),
  UNIQUE(genre_name))
;

CREATE TABLE IF NOT EXISTS movie_service.Movie_has_Genre (
  movie_id BIGINT NOT NULL REFERENCES Movie(movie_id),
  genre_id BIGINT NOT NULL REFERENCES Genre(genre_id),
  PRIMARY KEY (movie_id, genre_id)
);

CREATE TABLE IF NOT EXISTS movie_service.Movie_has_Actor (
  movie_id BIGINT NOT NULL REFERENCES Movie(movie_id),
  actor_id BIGINT NOT NULL REFERENCES Actor(actor_id),
  PRIMARY KEY (movie_id, actor_id)
);
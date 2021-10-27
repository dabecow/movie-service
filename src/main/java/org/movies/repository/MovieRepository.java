package org.movies.repository;

import org.movies.model.Actor;
import org.movies.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Page<Movie> findAll(Specification<Movie> specification, Pageable pageable);

}

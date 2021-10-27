package org.movies.service;

import org.movies.dto.ActorDto;
import org.movies.dto.GenreDto;
import org.movies.dto.MovieDto;
import org.movies.response.PageableResponse;
import org.springframework.data.domain.Pageable;

public interface IMovieService {
    MovieDto createMovie(MovieDto dto);
    void removeMovieById(Long id);
    PageableResponse<MovieDto> findAll(Pageable pageable);
    PageableResponse<MovieDto> findAllByGenre(GenreDto dto, Pageable pageable);
    PageableResponse<MovieDto> findAllByActor(ActorDto dto, Pageable pageable);
}

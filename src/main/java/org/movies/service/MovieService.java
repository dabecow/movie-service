package org.movies.service;

import lombok.RequiredArgsConstructor;
import org.movies.dto.ActorDto;
import org.movies.dto.GenreDto;
import org.movies.dto.MovieDto;
import org.movies.mapper.MovieMapper;
import org.movies.model.*;
import org.movies.repository.MovieRepository;
import org.movies.response.PageableResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.SetJoin;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService implements IMovieService{

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    @Override
    public MovieDto createMovie(MovieDto dto){
        Movie movie = movieRepository.save(movieMapper.fromDto(dto));
        return movieMapper.toDto(movie);
    }

    @Override
    public void removeMovieById(Long id){
        movieRepository.deleteById(id);
    }

    //TODO: reduce findAll methods so here will be only one method
    @Override
    public PageableResponse<MovieDto> findAll(Pageable pageable){
        Page<Movie> page = movieRepository.findAll(pageable);


        return new PageableResponse<>(page.getNumber(), page.getTotalElements(),
                page.getTotalPages(), movieMapper.toDtoList(page.getContent()));
    }

    @Override
    public PageableResponse<MovieDto> findAllByGenre(GenreDto genreDto, Pageable pageable) {
        Specification<Movie> specification = (root, query, criteriaBuilder) -> {
          SetJoin<Movie, Genre> joinGenres = root.join(Movie_.genres);
          return criteriaBuilder.equal(joinGenres.get(Genre_.NAME), genreDto.getName());
        };

        Page<Movie> page = movieRepository.findAll(specification, pageable);
        return new PageableResponse<>(page.getNumber(), page.getTotalElements(),
                page.getTotalPages(), movieMapper.toDtoList(page.getContent()));
    }

    @Override
    public PageableResponse<MovieDto> findAllByActor(ActorDto dto, Pageable pageable) {
        Specification<Movie> specification = (root, query, criteriaBuilder) -> {
            SetJoin<Movie, Actor> joinActors = root.join(Movie_.actors);
            return criteriaBuilder.equal(joinActors.get(Actor_.NAME), dto.getName());
        };

        Page<Movie> page = movieRepository.findAll(specification, pageable);
        return new PageableResponse<>(page.getNumber(), page.getTotalElements(),
                page.getTotalPages(), movieMapper.toDtoList(page.getContent()));
    }
}

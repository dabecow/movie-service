package org.movies.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.movies.dto.MovieDto;
import org.movies.model.Movie;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface MovieMapper {

    MovieDto toDto(Movie movie);

    List<MovieDto> toDtoList(List<Movie> movies);

    Movie fromDto(MovieDto dto);
}

package org.movies.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.movies.dto.MovieDto;
import org.movies.model.Movie;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface MovieMapper {

    @Mappings({
            @Mapping(target = "releaseDate", source = "movie.releaseDate", dateFormat = "dd-MM-yyyy")
    })
    MovieDto toDto(Movie movie);

    List<MovieDto> toDtoList(List<Movie> movies);

    @Mappings({
            @Mapping(target = "releaseDate", source = "dto.releaseDate", dateFormat = "dd-MM-yyyy")
    })
    Movie fromDto(MovieDto dto);
}

package org.movies.mapper;

import org.mapstruct.Mapper;
import org.movies.dto.GenreDto;
import org.movies.model.Genre;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface GenreMapper {

    GenreDto toDto(Genre genre);

    List<GenreDto> toDtoList(List<Genre> genres);

    Genre fromDto(GenreDto dto);
}

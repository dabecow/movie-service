package org.movies.mapper;

import org.mapstruct.Mapper;
import org.movies.dto.ActorDto;
import org.movies.model.Actor;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ActorMapper {

    ActorDto toDto(Actor actor);

    List<ActorDto> toDtoList(List<Actor> actors);

    Actor fromDto(ActorDto dto);
}

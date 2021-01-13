package com.prueba.menabikes.persistence.Mapper;

import com.prueba.menabikes.domain.Actor1;
import com.prueba.menabikes.persistence.entity.Actor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    @Mappings({
            @Mapping(source ="idActor", target = "actorId"),
            @Mapping(source ="nombre", target = "firstName"),
            @Mapping(source ="apellido", target = "lastName")
    })
    Actor1 toActor1(Actor actor);

    List<Actor1> toActors(List<Actor> actors);

    @InheritInverseConfiguration

    Actor toActor(Actor1 actor1);

}

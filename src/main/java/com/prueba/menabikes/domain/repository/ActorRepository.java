package com.prueba.menabikes.domain.repository;

import com.prueba.menabikes.domain.Actor1;
import com.prueba.menabikes.persistence.entity.Actor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface ActorRepository {
    List<Actor1> getAll();
    Optional<Actor1> getActor(int actorId);
    Actor1 save (Actor1 actor1);

    void delete(int actorId);
}

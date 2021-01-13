package com.prueba.menabikes.persistence.crud;

import com.prueba.menabikes.persistence.entity.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ActorCrudRepository extends CrudRepository<Actor, Integer> {

    List<Actor> findByIdActorOrderByNombreAsc(int idActor);




    //Optional<List<Actor>>
}

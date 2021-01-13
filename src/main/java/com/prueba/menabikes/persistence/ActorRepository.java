package com.prueba.menabikes.persistence;

import com.prueba.menabikes.domain.Actor1;
import com.prueba.menabikes.persistence.Mapper.ActorMapper;
import com.prueba.menabikes.persistence.crud.ActorCrudRepository;
import com.prueba.menabikes.persistence.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorRepository implements com.prueba.menabikes.domain.repository.ActorRepository {
    @Autowired
    private ActorCrudRepository actorCrudRepository;
    @Autowired
    private ActorMapper mapper;

    public List<Actor1> getAll(){
        List <Actor> actors = (List<Actor>) actorCrudRepository.findAll();
        return mapper.toActors(actors);
    }

    public Optional<List<Actor1>> getById(int actorId){
        List<Actor> actors = actorCrudRepository.findByIdActorOrderByNombreAsc(actorId);
        return Optional.of(mapper.toActors(actors));
    }

     public Optional<Actor1> getActor(int actorId){
      return actorCrudRepository.findById(actorId).map(actor -> mapper.toActor1(actor));
     }

    @Override
    public void delete(int actorId) {
        actorCrudRepository.deleteById(actorId);
    }

    @Override
    public Actor1 save(Actor1 actor1){
        Actor actor = mapper.toActor(actor1);
        return mapper.toActor1(actorCrudRepository.save(actor));
     }

}

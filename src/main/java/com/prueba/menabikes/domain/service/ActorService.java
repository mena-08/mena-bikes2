package com.prueba.menabikes.domain.service;

import com.prueba.menabikes.domain.Actor1;
import com.prueba.menabikes.domain.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor1> getAll(){
      return actorRepository.getAll();
    };

    public Optional<Actor1> getActor(int actorId){
        return actorRepository.getActor(actorId);
    };

    public Actor1 save(Actor1 actor1){
         return actorRepository.save(actor1);
    }

    public boolean delete(int actorId){
        return getActor(actorId).map(actor1 ->{
            actorRepository.delete(actorId);
            return true;
        }).orElse(false);
    }




}

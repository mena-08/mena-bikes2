package com.prueba.menabikes.web.controller;

import com.prueba.menabikes.domain.Actor1;
import com.prueba.menabikes.domain.service.ActorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/all")
    @ApiOperation("Get All actors names and Id's")
    public ResponseEntity<List<Actor1>> getAll(){
        return new ResponseEntity<>(actorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search an actor by Id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Actor Not found")
    })
    public ResponseEntity<Actor1> getActor(@PathVariable("id") int actorId){
        return actorService.getActor(actorId)
                .map(actor1 -> new ResponseEntity<>(actor1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Actor1> save(@RequestBody Actor1 actor1){
        return new ResponseEntity<>(actorService.save(actor1), HttpStatus.CREATED );
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int actorId){
        if(actorService.delete(actorId)){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}

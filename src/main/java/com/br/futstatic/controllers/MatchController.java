package com.br.futstatic.controllers;

import com.br.futstatic.dtos.post.NewMatch;
import com.br.futstatic.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @GetMapping
    public ResponseEntity getAllMatches(){
        return matchService.getAll();
    }

    @PostMapping
    public ResponseEntity postMatch(@RequestBody NewMatch newMatch){
        return matchService.postMatch(newMatch);
    }

    @PatchMapping("/finish/{id}")
    public ResponseEntity finishMatch(@PathVariable(value = "id") Long id){
        return matchService.finishMatch(id);
    }

}

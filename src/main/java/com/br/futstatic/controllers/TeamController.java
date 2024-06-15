package com.br.futstatic.controllers;

import com.br.futstatic.dtos.patch.ChangeCoach;
import com.br.futstatic.dtos.post.AddAward;
import com.br.futstatic.dtos.post.NewTeam;
import com.br.futstatic.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity getAll(){
        return teamService.getAllTeams();
    }

    @PostMapping
    public ResponseEntity postTeam(@RequestBody NewTeam newTeam){
        return teamService.postTeam(newTeam);
    }

    @PostMapping("/{id}/award")
    public ResponseEntity addAward(@PathVariable(value = "id") Long id, @RequestBody AddAward award){
        return teamService.addAward(id, award);
    }

    @PatchMapping("/{id}/coach")
    public ResponseEntity changeCoach(@PathVariable(value = "id") Long id, @RequestBody ChangeCoach coach){
        return teamService.changeCoach(id, coach);
    }
}

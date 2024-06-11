package com.br.futstatic.controllers;

import com.br.futstatic.dtos.patch.UpdatePlayer;
import com.br.futstatic.dtos.post.NewPlayer;
import com.br.futstatic.services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @GetMapping
    public ResponseEntity getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @PostMapping
    public ResponseEntity postPlayer(@RequestBody @Valid NewPlayer newPlayer){
        return playerService.postNewPlayer(newPlayer);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updatePlayer(@PathVariable(value = "id") Long id, @RequestBody UpdatePlayer updatePlayer) {
        return playerService.updatePlayer(id, updatePlayer);
    }
}

package com.br.futstatic.services;

import com.br.futstatic.dtos.NewPlayer;
import com.br.futstatic.dtos.PlayerDto;
import com.br.futstatic.models.Player;
import com.br.futstatic.models.Team;
import com.br.futstatic.repositories.PlayerRepository;
import com.br.futstatic.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    public ResponseEntity<List<PlayerDto>> getAllPlayers(){
        List<Player> players = playerRepository.findAll();
        List<PlayerDto> playerDtos = players.stream()
                .map(player -> new PlayerDto(player.getId(), player.getName(), player.getAge(),
                        Optional.ofNullable(player.getCurrentTeam()).map(Team::getName).orElse(null)))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(playerDtos);
    }

    public ResponseEntity postNewPlayer(NewPlayer newPlayer){
        Optional<Team> teamOptional = teamRepository.findByName(String.valueOf(newPlayer.currentTeam()));
        if(teamOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid team");
        }
        Team team = teamOptional.get();
        Player player = new Player(newPlayer, team);
        return ResponseEntity.ok().body(playerRepository.save(player));
    }
}

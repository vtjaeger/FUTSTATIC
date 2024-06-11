package com.br.futstatic.services;

import com.br.futstatic.dtos.patch.UpdatePlayer;
import com.br.futstatic.dtos.post.NewPlayer;
import com.br.futstatic.dtos.get.PlayerDto;
import com.br.futstatic.models.Player;
import com.br.futstatic.models.Team;
import com.br.futstatic.repositories.PlayerRepository;
import com.br.futstatic.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
                        Optional.ofNullable(player.getCurrentTeam()).map(Team::getName).orElse(null),
                        player.getPosition(), player.getNumber()))
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

    public ResponseEntity updatePlayer(Long id, UpdatePlayer dto){
        Optional<Player> playerOptional = playerRepository.findById(id);

        if(playerOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("player id not found.");
        }
        Player player = playerOptional.get();
        if(dto.age() != 0) {
            player.setAge(dto.age());
        }
        if(dto.number() != 0) {
            player.setAge(dto.number());
        }
        if(dto.position() != null) {
            player.setPosition(dto.position());
        }
        if(dto.currentTeam() != null) {
            Optional<Team> teamOptional = teamRepository.findByName(dto.currentTeam());
            if(teamOptional.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("team not found");
            }
            Team team = teamOptional.get();
            player.setCurrentTeam(team);
        }
        playerRepository.save(player);

        PlayerDto response = new PlayerDto(
                player.getId(),
                player.getName(),
                player.getAge(),
                player.getCurrentTeam() != null ? player.getCurrentTeam().getName() : null,
                player.getPosition(),
                player.getNumber()
        );
        return ResponseEntity.ok().body(response);
    }
}

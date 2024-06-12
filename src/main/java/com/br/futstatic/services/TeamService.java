package com.br.futstatic.services;

import com.br.futstatic.dtos.post.NewTeam;
import com.br.futstatic.dtos.get.TeamDto;
import com.br.futstatic.models.Player;
import com.br.futstatic.models.Team;
import com.br.futstatic.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public ResponseEntity<List<TeamDto>> getAllTeams(){
        List<Team> teams = teamRepository.findAll();
        List<TeamDto> response = teams.stream()
                .map(team -> new TeamDto(team.getId(),
                        team.getName(),
                        team.getCountry().toString(),
                        team.getPlayers().stream().map(Player::getName).collect(Collectors.toList()),
                        team.getCoach(),
                        team.getAwards()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    public ResponseEntity postTeam(NewTeam newTeam){
        Team team = new Team(newTeam);
        return ResponseEntity.ok().body(teamRepository.save(team));
    }
}

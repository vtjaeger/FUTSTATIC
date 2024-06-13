package com.br.futstatic.services;

import com.br.futstatic.dtos.get.MatchDto;
import com.br.futstatic.dtos.post.NewMatch;
import com.br.futstatic.models.Match;
import com.br.futstatic.models.Team;
import com.br.futstatic.repositories.MatchRepository;
import com.br.futstatic.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamRepository teamRepository;

    public ResponseEntity<List<MatchDto>> getAll(){
        List<Match> matches = matchRepository.findAll();
        List<MatchDto> response = matches.stream()
                .map(match -> new MatchDto(
                        match.getId(),
                        match.getHomeTeam().getName(),
                        match.getHomeTeam().getCoach(),
                        match.getVisitingTeam().getName(),
                        match.getVisitingTeam().getCoach(),
                        match.getScoreboard(),
                        match.getFinished(),
                        match.getStadium()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity postMatch(NewMatch newMatch){
        Optional<Team> team_home = teamRepository.findByName(newMatch.homeTeam());
        Optional<Team> visiting_team = teamRepository.findByName(newMatch.visitingTeam());
        if(team_home.isEmpty() || visiting_team.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("team not found");
        }
        Team homeTeam = team_home.get();
        Team visitingTeam = visiting_team.get();
        var match = new Match(newMatch, homeTeam, visitingTeam);
        return ResponseEntity.ok().body(matchRepository.save(match));
    }
}

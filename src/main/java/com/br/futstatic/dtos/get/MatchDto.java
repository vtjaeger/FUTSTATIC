package com.br.futstatic.dtos.get;

import com.br.futstatic.models.Stadium;

public record MatchDto(Long id, String homeTeam, String homeCoach, String visitingTeam, String visitingCoach, String scoreboard,
                       Boolean finished, Stadium stadium){
}

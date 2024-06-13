package com.br.futstatic.dtos.post;

import com.br.futstatic.models.Stadium;
import com.br.futstatic.models.Team;

public record NewMatch(String homeTeam, String visitingTeam, String scoreboard, Stadium stadium) {
}

package com.br.futstatic.dtos.get;

import com.br.futstatic.models.Positions;
import com.br.futstatic.models.Team;

import java.util.List;

public record PlayerDto(Long id, String name, int age, String currentTeamName, Positions position, int number, Boolean retired,
                        List<String> latestTeams) {
}

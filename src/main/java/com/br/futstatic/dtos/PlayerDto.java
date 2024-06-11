package com.br.futstatic.dtos;

import com.br.futstatic.models.Positions;

public record PlayerDto(Long id, String name, int age, String currentTeamName, Positions position, int number) {
}

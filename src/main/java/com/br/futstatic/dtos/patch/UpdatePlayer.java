package com.br.futstatic.dtos.patch;

import com.br.futstatic.models.Positions;

public record UpdatePlayer(int age, String currentTeam, Positions position, int number) {
}

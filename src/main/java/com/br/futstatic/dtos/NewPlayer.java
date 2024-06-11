package com.br.futstatic.dtos;

import com.br.futstatic.models.Positions;
import com.br.futstatic.models.Team;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewPlayer(
        @NotBlank
        String name,
        @NotNull
        int age,
        String currentTeam,
        Positions position,
        int number) {
}

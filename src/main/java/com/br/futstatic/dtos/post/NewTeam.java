package com.br.futstatic.dtos.post;

import com.br.futstatic.models.Countries;
import com.br.futstatic.models.Player;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record NewTeam(
        @NotBlank
        String name,
        @NotNull
        Countries country,
        List<Player> players,
        @NotBlank
        String coach,
        List<String> awards,
        @NotNull
        int yearFoundation) {
}

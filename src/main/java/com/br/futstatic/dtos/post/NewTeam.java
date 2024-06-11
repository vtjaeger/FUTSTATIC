package com.br.futstatic.dtos.post;

import com.br.futstatic.models.Countries;
import com.br.futstatic.models.Player;

import java.util.List;

public record NewTeam(
        String name,
        Countries country,
        List<Player> players,
        List<String> awards,
        int yearFoundation) {
}

package com.br.futstatic.dtos.get;

import java.util.List;

public record TeamDto(Long id, String name, String country, List<String> players, List<String> awards) {
}

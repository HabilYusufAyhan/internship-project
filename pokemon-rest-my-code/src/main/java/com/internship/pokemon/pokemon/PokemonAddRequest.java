package com.internship.pokemon.pokemon;

import lombok.Builder;

@Builder
public record PokemonAddRequest(String name , Integer owner) {
}

package com.internship.pokemon.pokemon;


import org.springframework.stereotype.Service;

@Service
public class PokemonMapper {

    public PokemonAddRequest toPokemonRequest(Pokemon trainer) {
        return PokemonAddRequest.builder()
                .name(trainer.getName())
                .build();
    }

    public Pokemon toPokemon(PokemonAddRequest pokemonRequest) {
        return Pokemon.builder()
                .name(pokemonRequest.name())
                .build();
    }

}
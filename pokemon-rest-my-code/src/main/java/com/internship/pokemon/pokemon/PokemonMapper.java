package com.internship.pokemon.trainer;

import com.internship.pokemon.pokemon.Pokemon;
import com.internship.pokemon.pokemon.PokemonAddRequest;
import org.springframework.stereotype.Service;

@Service
public class PokemonMapper {

    public PokemonAddRequest toPokemonRequest(Pokemon pokemon) {
        return PokemonAddRequest.builder()
                .name(pokemon.getName())
                .owner(pokemon.getOwner())
                .build();
    }

    public Pokemon toPokemon(PokemonAddRequest pokemonRequest) {
        return Pokemon.builder()
                .name(pokemonRequest.name())
                .owner(pokemonRequest.owner())
                .build();
    }

}
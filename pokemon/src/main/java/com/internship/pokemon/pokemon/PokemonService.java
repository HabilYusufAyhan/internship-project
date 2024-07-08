package com.internship.pokemon.pokemon;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }
    public Pokemon findPokemon(Integer id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        if (!pokemon.isPresent()){
            throw new RuntimeException("Pokemon not found");
        }
        return pokemon.get();
    }
    public Pokemon addPokemon(PokemonAddRequest pokemonAddRequest) {

        int[] levelPoints = {100, 500, 1000, 2000, 4000};

        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonAddRequest.name());
        pokemon.setLevel(1);
        pokemon.setRemainingPoint(levelPoints[0]);
        pokemon.setOwnerID(pokemonAddRequest.owner());
        Pokemon savedTrainer = pokemonRepository.save(pokemon);
        return savedTrainer;
    }

    public Pokemon updatePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

}

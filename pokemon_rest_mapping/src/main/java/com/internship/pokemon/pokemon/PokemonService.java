package com.internship.pokemon.pokemon;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    public Pokemon findPokemon(Integer id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);

        if (!pokemon.isPresent()) {
            throw new RuntimeException("Pokemon not found");
        }

        return pokemon.get();
    }

    public Pokemon createPokemon(PokemonAddRequest pokemonRequest) {
        Pokemon pokemon = pokemonMapper.toPokemon(pokemonRequest);
        pokemon.setId(0);
        Pokemon savedPokemon = pokemonRepository.save(pokemon);

        return savedPokemon;
    }

    public Pokemon updatePokemon(Integer id, PokemonAddRequest pokemonRequest) {
        Pokemon pokemon = findPokemon(id);
        pokemon.setName(pokemonRequest.name());


        Pokemon savedPokemon = pokemonRepository.save(pokemon);

        return savedPokemon;
    }

    public Pokemon deletePokemon(Integer id) {
        Pokemon pokemon = findPokemon(id);

        pokemonRepository.delete(pokemon);

        return pokemon;
    }

}

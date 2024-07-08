package com.internship.pokemon;

import com.internship.pokemon.pokemon.Pokemon;
import com.internship.pokemon.pokemon.PokemonAddRequest;
import com.internship.pokemon.pokemon.PokemonService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> findAll() {
        return pokemonService.findAll();
    }

    @GetMapping("/{pokemonId}")
    public Pokemon findPokemon(
            @PathVariable Integer pokemonId
    ) {

        return pokemonService.findPokemon(pokemonId);
    }

    @PostMapping
    public Pokemon createPokemon(
            @RequestBody PokemonAddRequest pokemonRequest
    ) {
        return pokemonService.createPokemon(pokemonRequest);
    }

    @PutMapping("/{pokemonId}")
    public Pokemon updatePokemon(
            @PathVariable Integer pokemonId,
            @RequestBody PokemonAddRequest pokemonRequest
    ) {
        return pokemonService.updatePokemon(pokemonId, pokemonRequest);
    }

    @DeleteMapping("/{pokemonId}")
    public Pokemon deletePokemon(
            @PathVariable Integer pokemonId
    ) {
        return pokemonService.deletePokemon(pokemonId);
    }

}
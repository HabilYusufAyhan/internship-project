package com.internship.pokemon.pokemon;


import com.internship.pokemon.trainer.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {

}

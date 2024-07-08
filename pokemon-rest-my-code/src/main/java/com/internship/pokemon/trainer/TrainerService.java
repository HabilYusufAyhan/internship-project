package com.internship.pokemon.trainer;

import com.internship.pokemon.pokemon.Pokemon;
import com.internship.pokemon.pokemon.PokemonAddRequest;
import com.internship.pokemon.pokemon.PokemonRepository;
import com.internship.pokemon.trainer.PokemonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }

    public Trainer findTrainer(Integer id) {
        Optional<Trainer> trainer = trainerRepository.findById(id);

        if (!trainer.isPresent()) {
            throw new RuntimeException("Trainer not found");
        }

        return trainer.get();
    }

    public Trainer createTrainer(TrainerAddRequest trainerRequest) {
        Trainer trainer = trainerMapper.toTrainer(trainerRequest);

        Trainer savedTrainer = trainerRepository.save(trainer);

        return savedTrainer;
    }

    public Trainer updateTrainer(Integer id, TrainerAddRequest trainerRequest) {
        Trainer trainer = findTrainer(id);
        trainer.setFirstName(trainerRequest.firstName());
        trainer.setLastName(trainerRequest.lastName());

        Trainer savedTrainer = trainerRepository.save(trainer);

        return savedTrainer;
    }

    public Trainer deleteTrainer(Integer id) {
        Trainer trainer = findTrainer(id);

        trainerRepository.delete(trainer);

        return trainer;
    }

    public Trainer spendCoin(Integer id, Integer amount) {
        Trainer trainer = findTrainer(id);
        trainer.setCoin(trainer.getCoin() - amount);
        Trainer savedTrainer = trainerRepository.save(trainer);
        return savedTrainer;
    }

    public Trainer buyPokemon(PokemonAddRequest pokemonRequest) {
       Pokemon pokemon = pokemonMapper.toPokemon(pokemonRequest);
    }
}
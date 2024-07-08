package com.internship.pokemon;

import com.internship.pokemon.pokemon.Pokemon;
import com.internship.pokemon.pokemon.PokemonAddRequest;
import com.internship.pokemon.pokemon.PokemonRepository;
import com.internship.pokemon.pokemon.PokemonService;
import com.internship.pokemon.trainer.Trainer;
import com.internship.pokemon.trainer.TrainerAddRequest;
import com.internship.pokemon.trainer.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequiredArgsConstructor
@RestController
public class DemoController {

    private final TrainerService trainerService;
    private final PokemonService pokemonService;
    private final PokemonRepository pokemonRepository;

    @GetMapping("/init")
    public void init() {
        System.out.println("All trainers:");
        for (Trainer trainer : trainerService.findAll()) {
            System.out.println(trainer);
        }

        System.out.println("Saving 1 trainers");
        TrainerAddRequest trainerAddRequest1 = new TrainerAddRequest("Emre", "Aydın" , 200);

        trainerService.addTrainer(trainerAddRequest1);


        System.out.println("All trainers after save:");
        for (Trainer trainer : trainerService.findAll()) {
            System.out.println(trainer);
        }
    }

    int[] levelPoints = {0,100, 500, 1000, 2000, 4000};
    @GetMapping("/init/gettrainer/{id}")
    public void getTrainer(@PathVariable("id") String id){
        System.out.println(trainerService.findTrainer(Integer.parseInt(id)));
    }

    @GetMapping("/buypokemon/{trainerId}")
    public void initpokemon(@PathVariable("trainerId") Integer trainerId) {

        Trainer trainer = trainerService.findTrainer(trainerId);

        if (trainer.getCoin() < 200) {
            System.out.println("Not enough coins!!");
            return;
        }

        System.out.println("Add pokemon:");

        PokemonAddRequest pokemonAddRequest = new PokemonAddRequest("Emre",trainerId);



        pokemonService.addPokemon(pokemonAddRequest);


        System.out.println("pokemon purchased");
        for (Pokemon pokemon : pokemonService.findAll()) {
            System.out.println(pokemon);
        }
    }

    @GetMapping("/trainpokemon/{trainerId}/{pokemonId}")
    public void trainPokemon(@PathVariable("trainerId") Integer trainerId, @PathVariable("pokemonId") Integer pokemonId) {
        Trainer trainer = trainerService.findTrainer(trainerId);
        Pokemon pokemon = pokemonService.findPokemon(pokemonId);
        if (pokemon.getOwnerID() != trainer.getId()) {
            System.out.println("This pokemon is not yours!!");

        }else{
            if (trainer.getCoin() < 20) {
                System.out.println("You don't have enough funds");
                return;
            }
            System.out.println("Training starts");
            trainer.setCoin(trainer.getCoin() - 20);
            trainerService.updateTrainer(trainer);
            Random rand = new Random();
            int randomNum = rand.nextInt(20) + 1;


            pokemon.setRemainingPoint(pokemon.getRemainingPoint() + randomNum);

            if (levelPoints[pokemon.getLevel()] < pokemon.getRemainingPoint()){
                pokemon.setLevel(pokemon.getLevel() + 1);
                pokemon.setRemainingPoint(pokemon.getRemainingPoint() - pokemon.getLevel());
                pokemonService.updatePokemon(pokemon);
            }
        }

    }




}
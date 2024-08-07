package com.internship.pokemon;

import com.internship.pokemon.pokemon.PokemonService;
import com.internship.pokemon.trainer.Trainer;
import com.internship.pokemon.trainer.TrainerAddRequest;
import com.internship.pokemon.trainer.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/game")
public class GameController {

    private final TrainerService trainerService;



    public GameController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }



    @GetMapping("/{trainerId}")
    public Trainer findTrainer(
            @PathVariable Integer trainerId
    ) {
        return trainerService.findTrainer(trainerId);
    }

    @PostMapping
    public Trainer createTrainer(
            @RequestBody TrainerAddRequest trainerRequest
    ) {
        return trainerService.createTrainer(trainerRequest);
    }

    @PutMapping("/{trainerId}")
    public Trainer updateTrainer(
            @PathVariable Integer trainerId,
            @RequestBody TrainerAddRequest trainerRequest
    ) {
        return trainerService.spendCoin(trainerId, 100);

    }

    @DeleteMapping("/{trainerId}")
    public Trainer deleteTrainer(
            @PathVariable Integer trainerId
    ) {
        return trainerService.deleteTrainer(trainerId);
    }

}



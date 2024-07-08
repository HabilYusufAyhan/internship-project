package com.internship.pokemon;

import com.internship.pokemon.trainer.Trainer;
import com.internship.pokemon.trainer.TrainerAddRequest;
import com.internship.pokemon.trainer.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> findAll() {
        return trainerService.findAll();
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
        return trainerService.updateTrainer(trainerId, trainerRequest);
    }

    @DeleteMapping("/{trainerId}")
    public Trainer deleteTrainer(
            @PathVariable Integer trainerId
    ) {
        return trainerService.deleteTrainer(trainerId);
    }

}
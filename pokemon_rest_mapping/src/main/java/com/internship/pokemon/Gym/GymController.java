package com.internship.pokemon.Gym;

import com.internship.pokemon.trainer.Trainer;
import com.internship.pokemon.trainer.TrainerAddRequest;
import com.internship.pokemon.trainer.TrainerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym")
public class GymController {
    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @GetMapping
    public List<Gym> findAll() {
        return gymService.findAll();
    }

    @GetMapping("/{gymId}")
    public Gym findGym(
            @PathVariable Integer gymId
    ) {

        return gymService.findGym(gymId);
    }

    @PostMapping
    public Gym createGym(
            @RequestBody GymAddRequest gymRequest
    ) {
        return gymService.createGym(gymRequest);
    }

    @PutMapping("/{gymId}")
    public Gym updateGym(
            @PathVariable Integer gymId,
            @RequestBody GymAddRequest gymRequest
    ) {

        return gymService.updateGym(gymId, gymRequest);
    }

    @DeleteMapping("/{gymId}")
    public Gym deleteGym(
            @PathVariable Integer gymId
    ) {
        return gymService.deleteGym(gymId);
    }
}

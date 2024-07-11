package com.internship.pokemon.Gym;


import com.internship.pokemon.trainer.Trainer;
import com.internship.pokemon.trainer.TrainerRepository;
import com.internship.pokemon.trainer.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GymService {
    private final GymRepository gymRepository;
    private final GymMapper gymMapper;
    private final TrainerRepository trainerRepository;

    public List<Gym> findAll() {
        return gymRepository.findAll();
    }

    public Gym findGym(Integer id) {
        Optional<Gym> gym = gymRepository.findById(id);

        if (!gym.isPresent()) {
            throw new RuntimeException("Gym not found");
        }

        return gym.get();
    }

    public Gym createGym(GymAddRequest gymRequest) {
        Gym gym  = gymMapper.toGym(gymRequest);

        Gym savedGym = gymRepository.save(gym);

        return savedGym;
    }

    public Gym updateGym(Integer id, GymAddRequest gymRequest) {
        Gym gym = findGym(id);
        gym.setName(gymRequest.name());


        Gym savedGym = gymRepository.save(gym);

        return savedGym;
    }

    public Gym deleteGym(Integer id) {
        Gym gym = findGym(id);

        gymRepository.delete(gym);

        return gym;
    }
}

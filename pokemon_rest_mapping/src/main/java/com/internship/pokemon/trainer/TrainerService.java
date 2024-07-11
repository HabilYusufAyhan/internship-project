package com.internship.pokemon.trainer;

import com.internship.pokemon.Gym.GymService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;
    private final GymService gymService;

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
        TrainerDetail trainerDetail = new TrainerDetail();
        trainerDetail.setTrainerType(trainerRequest.trainerType());
        trainerDetail.setLevel(trainerRequest.level());

        trainer.setTrainerDetail(trainerDetail);
        Trainer savedTrainer = trainerRepository.save(trainer);

        return savedTrainer;
    }

    public Trainer updateTrainer(Integer id, TrainerAddRequest trainerRequest) {
        Trainer trainer = findTrainer(id);
        trainer.setFirstName(trainerRequest.firstName());
        trainer.setLastName(trainerRequest.lastName());
        trainer.setGym(gymService.findGym(trainerRequest.gym()));
        Trainer savedTrainer = trainerRepository.save(trainer);

        return savedTrainer;
    }

    public Trainer deleteTrainer(Integer id) {
        Trainer trainer = findTrainer(id);

        trainerRepository.delete(trainer);

        return trainer;
    }
}
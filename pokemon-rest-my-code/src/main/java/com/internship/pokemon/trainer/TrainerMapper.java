package com.internship.pokemon.trainer;

import org.springframework.stereotype.Service;

@Service
public class TrainerMapper {

    public TrainerAddRequest toTrainerRequest(Trainer trainer) {
        return TrainerAddRequest.builder()
                .firstName(trainer.getFirstName())
                .lastName(trainer.getLastName())
                .coin(trainer.getCoin())
                .build();
    }

    public Trainer toTrainer(TrainerAddRequest trainerRequest) {
        return Trainer.builder()
                .firstName(trainerRequest.firstName())
                .lastName(trainerRequest.lastName())
                .coin(trainerRequest.coin())
                .build();
    }

}
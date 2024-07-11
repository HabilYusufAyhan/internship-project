package com.internship.pokemon.trainer;

import org.springframework.stereotype.Service;

@Service
public class TrainerMapper {

    public TrainerAddRequest toTrainerRequest(Trainer trainer) {
        return TrainerAddRequest.builder()
                .firstName(trainer.getFirstName())
                .lastName(trainer.getLastName())
                .role(trainer.getRole())
                .pw(trainer.getPw())
                .active(trainer.getActive())
                .userId(trainer.getUserId())
                .build();
    }

    public Trainer toTrainer(TrainerAddRequest trainerRequest) {
        return Trainer.builder()
                .firstName(trainerRequest.firstName())
                .lastName(trainerRequest.lastName())
                .role(trainerRequest.role())
                .pw(trainerRequest.pw())
                .active(trainerRequest.active())
                .userId(trainerRequest.userId())
                .build();
    }

}
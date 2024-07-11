package com.internship.pokemon.trainer;

import lombok.Data;

@Data
public class TrainerDTO {
    private int id;
    private String firstName;
    private String lastName;


    public static TrainerDTO fromEntity(Trainer trainer) {
        TrainerDTO dto = new TrainerDTO();
        dto.setId(trainer.getId());
        dto.setFirstName(trainer.getFirstName());
        dto.setLastName(trainer.getLastName());// Sadece `id`'yi al
        return dto;
    }
}

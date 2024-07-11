package com.internship.pokemon.Gym;

import com.internship.pokemon.trainer.Trainer;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GymDTO {
    private int id;
    private String name;
    private List<Integer> trainers;  // `Trainer`'ların sadece `id`'lerini içeren liste

    public static GymDTO fromEntity(Gym gym) {
        GymDTO dto = new GymDTO();
        dto.setId(gym.getId());
        dto.setName(gym.getName());

        // `trainers` listesini sadece `id`'lerle doldur
        dto.setTrainers(
                gym.getTrainers().stream()
                        .map(Trainer::getId)
                        .collect(Collectors.toList())
        );

        return dto;
    }
    public static List<GymDTO> toDTO(List<Gym> gyms) {
        return gyms.stream()
                .map(Gym::toDTO)
                .collect(Collectors.toList());  // `Gym` listesini `GymDTO` listesine dönüştür
    }
}
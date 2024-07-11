package com.internship.pokemon.Gym;


import org.springframework.stereotype.Service;

@Service
public class GymMapper {
    public GymAddRequest toGymAddRequest(Gym gym) {
        return GymAddRequest.builder()
                .name(gym.getName())

                .build();
    }

    public Gym toGym(GymAddRequest gymRequest) {
        return Gym.builder()
                .name(gymRequest.name())

                .build();
    }
}

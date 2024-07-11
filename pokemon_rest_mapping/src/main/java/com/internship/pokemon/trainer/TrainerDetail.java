package com.internship.pokemon.trainer;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "trainer_detail")
public class TrainerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int level;
    @Enumerated(EnumType.STRING)
    private TrainerType trainerType;

}

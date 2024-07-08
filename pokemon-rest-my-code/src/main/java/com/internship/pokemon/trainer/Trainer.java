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
@Table(name = "train")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int coin;


    public Trainer(String firstName, String lastName, Integer coin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.coin = coin;
    }






}





package com.internship.pokemon.pokemon;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int owner;


    public Pokemon(String name, int owner) {
        this.name = name;
        this.owner = owner;
    }
}





package com.internship.pokemon.trainer;

import lombok.Builder;

@Builder
public record TrainerAddRequest(String firstName,String lastName,Integer coin) {

}

package com.internship.pokemon.trainer;

import lombok.Builder;

@Builder
public record TrainerAddRequest(String firstName,String lastName,String role,String pw,int active,String userId) {

}

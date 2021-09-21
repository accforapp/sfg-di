package com.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cat")
public class CatPetService implements PetService {
  @Override
  public String getPetType() {
    return "Cats are the Best!";
  }
}

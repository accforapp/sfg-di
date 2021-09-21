package com.springframework.pets;

import java.util.Objects;

public class PetFactory {

  public PetService getPetType(String petType) {
    if (Objects.equals(petType, "dog")) {
      return new DogPetService();
    } else if (Objects.equals(petType, "cat")) {
      return new CatPetService();
    }
    return new DogPetService();
  }
}

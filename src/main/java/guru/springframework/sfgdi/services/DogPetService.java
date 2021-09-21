package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dog")
public class DogPetService implements PetService {
  @Override
  public String getPetType() {
    return "Dogs are the best!";
  }
}
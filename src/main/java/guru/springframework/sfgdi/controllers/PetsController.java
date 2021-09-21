package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.PetService;
import org.springframework.stereotype.Controller;

@Controller
public class PetsController {
  private final PetService petService;

  public PetsController(PetService petService) {
    this.petService = petService;
  }

  public void whichPetIsBetter() {
    petService.getPetType();
  }
}

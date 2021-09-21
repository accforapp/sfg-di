package guru.springframework.sfgdi.controllers;

import com.springframework.pets.PetService;
import org.springframework.stereotype.Controller;

@Controller
public class PetsController {
  private final PetService petService;

  public PetsController(PetService petService) {
    this.petService = petService;
  }

  public void whichPetIsBetter() {
    System.out.println(petService.getPetType());
  }
}

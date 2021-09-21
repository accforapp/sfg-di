package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorController {
  GreetingService constructorGreetingService;

  public ConstructorController(GreetingService constructorGreetingService) {
    this.constructorGreetingService = constructorGreetingService;
  }

  public void sayHello() {
    System.out.println(constructorGreetingService.sayGreeting());
  }
}

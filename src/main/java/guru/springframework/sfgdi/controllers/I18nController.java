package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class I18nController {
  private final GreetingService greetingService;

  public I18nController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public void sayHello() {
    System.out.println(greetingService.sayGreeting());
  }
}

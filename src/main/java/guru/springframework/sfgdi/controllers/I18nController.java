package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class I18nController {
  private final GreetingService i18nService;

  public I18nController(GreetingService i18nService) {
    this.i18nService = i18nService;
  }

  public void sayHello() {
    System.out.println(i18nService.sayGreeting());
  }
}

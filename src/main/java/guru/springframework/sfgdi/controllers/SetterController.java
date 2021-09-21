package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SetterController {
  GreetingService setterInjectedGreetingService;

  @Autowired
  public void setSetterInjectedGreetingService(GreetingService setterInjectedGreetingService) {
    this.setterInjectedGreetingService = setterInjectedGreetingService;
  }

  public void sayHello() {
    System.out.println(setterInjectedGreetingService.sayGreeting());
  }
}

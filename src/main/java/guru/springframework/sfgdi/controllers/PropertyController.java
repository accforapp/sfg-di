package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyController {
  @Autowired
  GreetingService propertyInjectedGreetingService;

  public void sayHello() {
    System.out.println(propertyInjectedGreetingService.sayGreeting());
  }
}

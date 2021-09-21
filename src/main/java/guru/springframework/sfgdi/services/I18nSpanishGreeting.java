package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("greetingService")
@Profile({"EN", "default"})
public class I18nSpanishGreeting implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Hola Mundo - ES";
  }
}

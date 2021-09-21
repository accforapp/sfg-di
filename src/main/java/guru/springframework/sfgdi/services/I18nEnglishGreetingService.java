package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("greetingService")
@Profile("EN")
public class I18nEnglishGreetingService implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Hello World - EN";
  }
}

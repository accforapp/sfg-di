package guru.springframework.sfgdi.services;


public class I18nSpanishGreeting implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Hola Mundo - ES";
  }
}

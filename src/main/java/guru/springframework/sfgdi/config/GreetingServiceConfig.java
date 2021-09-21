package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

  @Profile("EN")
  @Bean("i18nService")
  I18nEnglishGreetingService i18nEnglishGreetingService() {
    return new I18nEnglishGreetingService();
  }

  @Profile({"ES", "default"})
  @Bean
  I18nSpanishGreeting i18nService() {
    return new I18nSpanishGreeting();
  }

  @Bean
  ConstructorGreetingService constructorGreetingService() {
    return new ConstructorGreetingService();
  }

  @Bean
  PropertyInjectedGreetingService propertyInjectedGreetingService() {
    return new PropertyInjectedGreetingService();
  }

  @Bean
  SetterInjectedGreetingService setterInjectedGreetingService() {
    return new SetterInjectedGreetingService();
  }
}

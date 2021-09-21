package guru.springframework.sfgdi.config;

import com.springframework.pets.DogPetService;
import com.springframework.pets.PetFactory;
import com.springframework.pets.PetService;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

  @Bean
  PetFactory petFactory() {
    return new PetFactory();
  }

  @Bean
  @Profile({"dog", "default"})
  PetService dogPetService(PetFactory petFactory) {
    return petFactory.getPetType("dog");
  }

  @Bean
  @Profile("cat")
  PetService catPetService(PetFactory petFactory) {
    return petFactory.getPetType("cat");
  }

  @Bean
  EnglishGreetingRepository englishGreetingRepository() {
    return new EnglishGreetingRepositoryImpl();
  }

  @Profile("EN")
  @Bean("i18nService")
  I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
    return new I18nEnglishGreetingService(englishGreetingRepository);
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

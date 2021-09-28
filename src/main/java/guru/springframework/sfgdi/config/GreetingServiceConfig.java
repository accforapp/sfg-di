package guru.springframework.sfgdi.config;

import com.springframework.pets.DogPetService;
import com.springframework.pets.PetFactory;
import com.springframework.pets.PetService;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@EnableConfigurationProperties(SfgConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

  @Bean
  FakeDataSource fakeDataSource(SfgConstructorConfig sfgConstructorConfig) {
    FakeDataSource fakeDataSource = new FakeDataSource();
    fakeDataSource.setUsername(sfgConstructorConfig.getUsername());
    fakeDataSource.setPassword(sfgConstructorConfig.getPassword());
    fakeDataSource.setJdbcurl(sfgConstructorConfig.getJdbcurl());

    return fakeDataSource;
  }

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

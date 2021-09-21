package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.PetsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

		I18nController controller = context.getBean(I18nController.class);
		controller.sayHello();

		PetsController petsController = context.getBean(PetsController.class);
		petsController.whichPetIsBetter();
	}

}

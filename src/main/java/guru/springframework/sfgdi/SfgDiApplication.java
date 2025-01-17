package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.SfgConfiguration;
import guru.springframework.sfgdi.config.SfgConstructorConfig;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

		I18nController controller = context.getBean(I18nController.class);
		controller.sayHello();

		PetsController petsController = context.getBean(PetsController.class);
		petsController.whichPetIsBetter();

		ConstructorController constructorController = context.getBean(ConstructorController.class);
		constructorController.sayHello();

		PropertyController propertyController = context.getBean(PropertyController.class);
		propertyController.sayHello();

		SetterController setterController = context.getBean(SetterController.class);
		setterController.sayHello();

		System.out.println("----------Scope Beans-------------");

		SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("-------------Fake DataSource---------");
		FakeDataSource fakeDataSource = context.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

		System.out.println("-------------Config props bean---------");
		SfgConfiguration sfgDiApplication = context.getBean(SfgConfiguration.class);
		System.out.println(sfgDiApplication.getUsername());
		System.out.println(sfgDiApplication.getPassword());
		System.out.println(sfgDiApplication.getJdbcurl());

		System.out.println("------------Constructor config----------");
		SfgConstructorConfig sfgConstructorConfig = context.getBean(SfgConstructorConfig.class);
		System.out.println(sfgConstructorConfig.getUsername());
		System.out.println(sfgConstructorConfig.getPassword());
		System.out.println(sfgConstructorConfig.getJdbcurl());
	}

}

package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController) context.getBean("i18nController");
		System.out.println(i18nController.sayHello());


		System.out.println("---------- Primary Bean");
		MyController myController = (MyController) context.getBean("myController");
		System.out.println(myController.sayHello());

		System.out.println("----------- Property");
		PropertyInjectedController propertyInjectedController =
			(PropertyInjectedController) context.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----------- Setter");
		SetterInjectedController setterInjectedController =
			(SetterInjectedController) context.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----------- Constructor");
		ConstructorInjectedController constructorInjectedController =
			(ConstructorInjectedController) context.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}

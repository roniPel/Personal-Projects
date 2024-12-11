package FileSystem.example.FileManagementSystem_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FileManagementSystemSpringApplication {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		//SpringApplication.run(FileManagementSystemSpringApplication.class, args);
		applicationContext = SpringApplication.run(FileManagementSystemSpringApplication.class, args);
		//displayAllBeans();

	}
	public static void displayAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for(String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}

}

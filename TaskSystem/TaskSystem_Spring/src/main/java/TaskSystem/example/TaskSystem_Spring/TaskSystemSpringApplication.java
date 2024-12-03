package TaskSystem.example.TaskSystem_Spring;

import TaskSystem.example.TaskSystem_Spring.Beans.UserDetails;
import TaskSystem.example.TaskSystem_Spring.Beans.UserType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableScheduling
public class TaskSystemSpringApplication {

	public static void main(String[] args) throws Exception {
		try {
			ApplicationContext ctx = SpringApplication.run(TaskSystemSpringApplication.class, args);
//		SpringApplication.run(TaskSystemSpringApplication.class, args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

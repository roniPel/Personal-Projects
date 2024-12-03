package FileSystem.example.FileManagementSystem_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileManagementSystemSpringApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(FileManagementSystemSpringApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package co.com.uni5d.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("co.com.uni5d")
public class Uni5dControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Uni5dControllerApplication.class, args);
	}
}

package ro.digitalnation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "Clase")
@EnableJpaRepositories(basePackages = "Repositories")
@ComponentScan(basePackages = {"ro.digitalnation","Services","Repositories"})
public class MironIonAlexandruApplication {

	public static void main(String[] args) {
		SpringApplication.run(MironIonAlexandruApplication.class, args);
	}

}

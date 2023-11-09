package com.company.dbrestcrud;

//import com.company.dbrestcrud.entity.Employee;
//import jakarta.persistence.EntityManager;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbrestcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbrestcrudApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(EntityManager entityManager) {
//		return runner -> {
//			System.out.println(entityManager.find(Employee.class, 4));
//		};
//	}
}

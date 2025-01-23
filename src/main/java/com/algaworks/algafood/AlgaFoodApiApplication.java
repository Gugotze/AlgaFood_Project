package com.algaworks.algafood;

import com.algaworks.algafood.service.impl.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class AlgaFoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgaFoodApiApplication.class, args);
	}

}

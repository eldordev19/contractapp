package uz.rtmc.contractapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ContractappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractappApplication.class, args);
	}

}

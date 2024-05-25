package dev.patika.VeterinaryManagementSystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Veterinary Management System", version = "1.0", description = "Veteriner Yönetim Sistemi"))
public class VeterinaryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinaryManagementSystemApplication.class, args);
	}

}

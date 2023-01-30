package com.aggregrator.ambulanceservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Ambulance API", version = "1.0", description = "This is documentation for all ambulance service"))
public class AmbulanceServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AmbulanceServiceApplication.class, args);
	}

}

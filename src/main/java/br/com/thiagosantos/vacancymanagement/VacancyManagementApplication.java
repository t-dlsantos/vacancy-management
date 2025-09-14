package br.com.thiagosantos.vacancymanagement;

import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
            title = "Gestão de Vagas",
            description = "API responsável pela gestão de vagas",
            version = "1.0"
    )
)
public class VacancyManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacancyManagementApplication.class, args);
    }

}

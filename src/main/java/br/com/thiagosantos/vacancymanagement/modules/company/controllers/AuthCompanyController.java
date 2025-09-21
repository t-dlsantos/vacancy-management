package br.com.thiagosantos.vacancymanagement.modules.company.controllers;

import br.com.thiagosantos.vacancymanagement.modules.company.dto.AuthCompanyRequestDTO;
import br.com.thiagosantos.vacancymanagement.modules.company.useCases.AuthCompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/company")
@Tag(name = "Company", description = "Company's information")
public class AuthCompanyController {

    private final AuthCompanyUseCase authCompanyUseCase;

    @Autowired
    public AuthCompanyController(AuthCompanyUseCase authCompanyUseCase) {
        this.authCompanyUseCase = authCompanyUseCase;
    }

    @PostMapping("/auth")
    @Operation(summary = "Company authentication", description = "This function is responsible for authenticate the company")
    public ResponseEntity<Object> create(@RequestBody AuthCompanyRequestDTO authCompanyRequestDTO) {
        try {
            var result = this.authCompanyUseCase.execute(authCompanyRequestDTO);
            return ResponseEntity.ok().body(result);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
package br.com.thiagosantos.vacancymanagement.modules.company.controllers;

import br.com.thiagosantos.vacancymanagement.modules.cadidate.entities.CandidateEntity;
import br.com.thiagosantos.vacancymanagement.modules.company.entities.CompanyEntity;
import br.com.thiagosantos.vacancymanagement.modules.company.useCases.CreateCompanyUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@Tag(name = "Company", description = "Company's information")
public class CompanyController {

   private final CreateCompanyUseCase createCompanyUseCase;

   @Autowired
   public CompanyController(CreateCompanyUseCase createCompanyUseCase) {
       this.createCompanyUseCase = createCompanyUseCase;
   }

   @PostMapping("/")
   @Operation(summary = "Company creation", description = "This function is responsible for create a new company")
   @ApiResponses({
           @ApiResponse(responseCode = "200", content = {
                   @Content(schema = @Schema(implementation = CandidateEntity.class))
           }),
           @ApiResponse(responseCode = "400", description = "Company already exists")
   })
   public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
       try {
           var result = this.createCompanyUseCase.execute(companyEntity);
           return ResponseEntity.ok().body(result);
       } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
   }
}
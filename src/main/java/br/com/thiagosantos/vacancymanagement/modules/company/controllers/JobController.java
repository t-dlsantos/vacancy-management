package br.com.thiagosantos.vacancymanagement.modules.company.controllers;

import br.com.thiagosantos.vacancymanagement.modules.company.entities.JobEntity;
import br.com.thiagosantos.vacancymanagement.modules.company.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job/")
public class JobController {

    private final CreateJobUseCase createJobUseCase;

    public JobController(CreateJobUseCase createJobUseCase) {
        this.createJobUseCase = createJobUseCase;
    }

    @PostMapping("/")
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity) {
        return this.createJobUseCase.execute(jobEntity);
    }
}
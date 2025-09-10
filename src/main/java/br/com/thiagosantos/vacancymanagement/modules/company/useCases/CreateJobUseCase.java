package br.com.thiagosantos.vacancymanagement.modules.company.useCases;

import br.com.thiagosantos.vacancymanagement.modules.company.entities.JobEntity;
import br.com.thiagosantos.vacancymanagement.modules.company.repositories.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    private final JobRepository jobRepository;

    public CreateJobUseCase(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }

}
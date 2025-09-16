package br.com.thiagosantos.vacancymanagement.modules.company.useCases;

import br.com.thiagosantos.vacancymanagement.exceptions.CompanyNotFoundException;
import br.com.thiagosantos.vacancymanagement.modules.company.entities.JobEntity;
import br.com.thiagosantos.vacancymanagement.modules.company.repositories.CompanyRepository;
import br.com.thiagosantos.vacancymanagement.modules.company.repositories.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public CreateJobUseCase(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(CompanyNotFoundException::new);
        return this.jobRepository.save(jobEntity);
    }

}
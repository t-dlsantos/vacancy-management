package br.com.thiagosantos.vacancymanagement.modules.cadidate.useCases;

import br.com.thiagosantos.vacancymanagement.exceptions.JobNotFoundException;
import br.com.thiagosantos.vacancymanagement.exceptions.UserNotFoundException;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.entities.ApplyJobEntity;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.repositories.ApplyJobRepository;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.repositories.CandidateRepository;
import br.com.thiagosantos.vacancymanagement.modules.company.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    private final JobRepository jobRepository;
    private final CandidateRepository candidateRepository;
    private final ApplyJobRepository applyJobRepository;

    public ApplyJobCandidateUseCase(JobRepository jobRepository, CandidateRepository candidateRepository, ApplyJobRepository applyJobRepository) {
        this.jobRepository = jobRepository;
        this.candidateRepository = candidateRepository;
        this.applyJobRepository = applyJobRepository;
    }

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(UserNotFoundException::new);

        this.jobRepository.findById(idJob)
                .orElseThrow(JobNotFoundException::new);

        var applyJob = ApplyJobEntity.builder()
                        .candidateId(idCandidate)
                        .jobId(idJob)
                        .build();

        return applyJobRepository.save(applyJob);
    }

}
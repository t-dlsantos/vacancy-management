package br.com.thiagosantos.vacancymanagement.modules.candidate.useCases;

import br.com.thiagosantos.vacancymanagement.exceptions.JobNotFoundException;
import br.com.thiagosantos.vacancymanagement.exceptions.UserNotFoundException;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.entities.ApplyJobEntity;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.entities.CandidateEntity;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.repositories.ApplyJobRepository;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.repositories.CandidateRepository;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.useCases.ApplyJobCandidateUseCase;
import br.com.thiagosantos.vacancymanagement.modules.company.entities.JobEntity;
import br.com.thiagosantos.vacancymanagement.modules.company.repositories.JobRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Test
    @DisplayName("Should not be able to apply job with candidate not found")
    public void shouldNotBeAbleToApplyJobWithCandidateNotFound() {
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    @DisplayName("Should not be able to apply job with job not found")
    public void shouldNotBeAbleToApplyJobWithJobNotFound() {
        var idCandidate = UUID.randomUUID();

        var candidate = new CandidateEntity();
        candidate.setId(idCandidate);

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }
    }

    @Test
    @DisplayName("Should be able to create a new apply job")
    public void shouldBeAbleToCreateANewApplyJob() {
        var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJob = ApplyJobEntity.builder()
                        .candidateId(idCandidate)
                        .jobId(idJob)
                        .build();

        var applyJobCreated = ApplyJobEntity.builder().id(UUID.randomUUID()).build();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobRepository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));

        when(applyJobRepository.save(applyJob)).thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(idCandidate, idJob);

        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());
    }
}
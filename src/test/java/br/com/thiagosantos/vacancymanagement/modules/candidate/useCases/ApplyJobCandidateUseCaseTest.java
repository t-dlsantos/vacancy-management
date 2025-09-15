package br.com.thiagosantos.vacancymanagement.modules.candidate.useCases;

import br.com.thiagosantos.vacancymanagement.exceptions.JobNotFoundException;
import br.com.thiagosantos.vacancymanagement.exceptions.UserNotFoundException;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.entities.CandidateEntity;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.repositories.CandidateRepository;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.useCases.ApplyJobCandidateUseCase;
import br.com.thiagosantos.vacancymanagement.modules.company.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

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
}
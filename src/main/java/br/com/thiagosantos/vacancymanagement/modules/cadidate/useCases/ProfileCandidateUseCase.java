package br.com.thiagosantos.vacancymanagement.modules.cadidate.useCases;

import br.com.thiagosantos.vacancymanagement.exceptions.UserNotFoundException;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.dto.ProfileCandidateResponseDTO;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    private final CandidateRepository candidateRepository;

    public ProfileCandidateUseCase(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(UserNotFoundException::new);

        return ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .id(candidate.getId())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .build();
    }
}
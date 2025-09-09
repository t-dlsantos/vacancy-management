package br.com.thiagosantos.vacancymanagement.modules.cadidate.useCases;

import br.com.thiagosantos.vacancymanagement.exceptions.UserFoundException;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.CandidateEntity;
import br.com.thiagosantos.vacancymanagement.modules.cadidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent(user -> {
            throw new UserFoundException();
        });

        return this.candidateRepository.save(candidateEntity);
    }
}
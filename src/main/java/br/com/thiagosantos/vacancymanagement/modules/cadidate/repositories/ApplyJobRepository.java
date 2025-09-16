package br.com.thiagosantos.vacancymanagement.modules.cadidate.repositories;

import br.com.thiagosantos.vacancymanagement.modules.cadidate.entities.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
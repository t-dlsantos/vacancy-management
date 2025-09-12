package br.com.thiagosantos.vacancymanagement.modules.cadidate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileCandidateResponseDTO {

    private String description;
    private String username;
    private String email;
    private UUID id;
    private String name;

}
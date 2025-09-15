package br.com.thiagosantos.vacancymanagement.modules.cadidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "Java Developer")
    private String description;

    @Schema(example = "thigas")
    private String username;

    @Schema(example = "thiago@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "Thiago Santos")
    private String name;

}
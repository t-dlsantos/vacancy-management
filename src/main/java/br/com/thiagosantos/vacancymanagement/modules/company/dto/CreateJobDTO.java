package br.com.thiagosantos.vacancymanagement.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Position for junior java developer", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Day Off, Health Insurance Plan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "JUNIOR", requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;

}
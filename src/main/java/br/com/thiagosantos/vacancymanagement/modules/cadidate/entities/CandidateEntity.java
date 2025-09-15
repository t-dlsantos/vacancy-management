package br.com.thiagosantos.vacancymanagement.modules.cadidate.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Thiago Santos", requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate's name")
    private String name;

    @Schema(example = "thigas", requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate's username")
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    private String username;

    @Schema(example = "thiago@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate's e-mail")
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    @Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate's password")
    private String password;

    @Schema(example = "Java developer", requiredMode = Schema.RequiredMode.REQUIRED, description = "A brief description of the candidate")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
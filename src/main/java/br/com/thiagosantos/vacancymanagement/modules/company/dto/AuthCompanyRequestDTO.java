package br.com.thiagosantos.vacancymanagement.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyRequestDTO {

    private String password;
    private String username;

}
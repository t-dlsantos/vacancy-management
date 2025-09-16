package br.com.thiagosantos.vacancymanagement.modules.company.controllers;

import br.com.thiagosantos.vacancymanagement.modules.company.dto.CreateJobDTO;
import br.com.thiagosantos.vacancymanagement.modules.company.entities.CompanyEntity;
import br.com.thiagosantos.vacancymanagement.modules.company.repositories.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static br.com.thiagosantos.vacancymanagement.utils.TestUtils.generateToken;
import static br.com.thiagosantos.vacancymanagement.utils.TestUtils.objectToJSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc()
@ActiveProfiles("test")
public class CreateJobControllerTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldBeAbleToCreateANewJob() throws Exception {
        var company = CompanyEntity.builder()
                .description("COMPANY_DESCRIPTION")
                .email("email@company.com")
                .password("1234567890")
                .username("COMPANY_USERNAME")
                .name("COMPANY_NAME")
                .build();

        company = companyRepository.saveAndFlush(company);

        var createJobDTO = CreateJobDTO.builder()
                .benefits("BENEFITS_TEST")
                .description("DESCRIPTION_TEST")
                .level("LEVEL_TESTE")
                .build();

        mvc.perform(
                MockMvcRequestBuilders.post("/company/job/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJSON(createJobDTO))
                        .header("Authorization",
                                generateToken(company.getId(),
                                        "JAVAGAS_@123$"))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldNotBeAbleToCreateANewJobIfCompanyNotFound() throws Exception {
        var createJobDTO = CreateJobDTO.builder()
                .benefits("BENEFITS_TEST")
                .description("DESCRIPTION_TEST")
                .level("LEVEL_TESTE")
                .build();

        mvc.perform(
                MockMvcRequestBuilders.post("/company/job/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectToJSON(createJobDTO))
                        .header("Authorization", generateToken(UUID.randomUUID(), "JAVAGAS_@123$"))
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}
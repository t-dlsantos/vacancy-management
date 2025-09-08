package br.com.thiagosantos.vacancymanagement.modules.cadidate.controllers;

import br.com.thiagosantos.vacancymanagement.modules.cadidate.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create(@Valid @RequestBody CandidateEntity candidate) {
        System.out.println("Candidate email: " + candidate.getEmail());
    }
}
package com.periferiag.xman.service;

import com.periferiag.xman.dto.Adn;
import org.springframework.http.ResponseEntity;

public interface IMutantes {

    Boolean isMutant(String[] dna);
    ResponseEntity isMutante(Adn dna);
}

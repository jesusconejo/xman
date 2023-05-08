package com.periferiag.xman.service;

import com.periferiag.xman.dto.Adn;
import com.periferiag.xman.dto.Respuesta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class MutantesServiceTest {

    @Test
    void isMutante() {
        MutantesService mutantesService = new MutantesService();
        Adn dna =  new Adn();
        dna.setDna(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        ResponseEntity<Respuesta> resultado = mutantesService.isMutante(dna);
        Assertions.assertEquals("MUTANTE",resultado.getBody().getMutantHuman());

    }

    @Test
    void isMutant() {
        MutantesService mutantesService = new MutantesService();
        boolean resultado = mutantesService.isMutant(new String[]{"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"});
        Assertions.assertTrue(resultado);
    }
}
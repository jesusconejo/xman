package com.periferiag.xman.service;

import com.periferiag.xman.dto.Adn;
import com.periferiag.xman.dto.Respuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MutantesService implements  IMutantes{
    protected static final Logger logger = LoggerFactory.getLogger(MutantesService.class);
    @Override
    public ResponseEntity<Respuesta> isMutante(Adn dna) {
       Respuesta respuesta = new Respuesta();
        try{
            if(isMutant(dna.getDna())){
                respuesta.setMutantHuman("MUTANTE");
                return new ResponseEntity(respuesta,HttpStatus.OK);
            }
            respuesta.setMutantHuman("HUMANO");
            return  new ResponseEntity(respuesta,HttpStatus.FORBIDDEN);
        }catch (Exception e){
            logger.error(this.getClass().getName()+" isMutante "+e);
        }

        return null;
    }

    public Boolean isMutant(String[] dna) {
        int n = dna.length;
        int count = 0;
        char[][] matrix = new char[n][n];

        // Convertimos el array de Strings en una matriz de caracteres
        for (int i = 0; i < n; i++) {
            matrix[i] = dna[i].toCharArray();
        }

        // Verificamos las secuencias horizontales
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] == matrix[i][j+1]) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Verificamos las secuencias verticales
        for (int j = 0; j < n; j++) {
            count = 0;
            for (int i = 0; i < n - 1; i++) {
                if (matrix[i][j] == matrix[i+1][j]) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        // Verificamos las secuencias oblicuas hacia la derecha
        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < n - 3; j++) {
                if (matrix[i][j] == matrix[i+1][j+1] &&
                        matrix[i+1][j+1] == matrix[i+2][j+2] &&
                        matrix[i+2][j+2] == matrix[i+3][j+3]) {
                    return true;
                }
            }
        }

        // Verificamos las secuencias oblicuas hacia la izquierda
        for (int i = 0; i < n - 3; i++) {
            for (int j = n - 1; j >= 3; j--) {
                if (matrix[i][j] == matrix[i+1][j-1] &&
                        matrix[i+1][j-1] == matrix[i+2][j-2] &&
                        matrix[i+2][j-2] == matrix[i+3][j-3]) {
                    return true;
                }
            }
        }

        return false;
    }



}

package com.periferiag.xman.controller;

import com.periferiag.xman.dto.Adn;
import com.periferiag.xman.dto.Respuesta;
import com.periferiag.xman.service.MutantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Xman/api/v1")
@CrossOrigin(origins="*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.OPTIONS},allowedHeaders = "*")
public class MutantesXmanController {

    @Autowired
    private MutantesService service;

    @PostMapping("/mutant")
    public ResponseEntity<Respuesta> isMutante(@RequestBody Adn adn){
        return service.isMutante(adn);



    }


}

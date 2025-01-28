package com.SpringJpa.demo.controller;

import com.SpringJpa.demo.dto.AutorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @PostMapping
    public ResponseEntity salvar(@RequestBody AutorDTO autor){
        return new ResponseEntity("Autor salvo com sucesso! "+autor, HttpStatus.CREATED);

    }
}

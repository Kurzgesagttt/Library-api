package com.SpringJpa.demo.controller;

import com.SpringJpa.demo.dto.AutorDTO;
import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.repository.AutorRepository;
import com.SpringJpa.demo.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody AutorDTO autor){
        Autor autorEntidade = autor.mapearAutor();
        service.salvarAutor(autorEntidade);
        return new ResponseEntity("Autor salvo com sucesso! "+autor, HttpStatus.CREATED);

    }
}

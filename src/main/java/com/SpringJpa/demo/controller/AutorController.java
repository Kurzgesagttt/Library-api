package com.SpringJpa.demo.controller;

import com.SpringJpa.demo.dto.AutorDTO;
import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.repository.AutorRepository;
import com.SpringJpa.demo.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController(AutorService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody AutorDTO autor){
        Autor autorEntidade = autor.mapearAutor();
        service.salvarAutor(autorEntidade);


        //retorna o ID da entidade criada na url para o padrao rest
        URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(autorEntidade.getId())
                .toUri();


        return ResponseEntity.created(location).build();

    }
}

package com.SpringJpa.demo.controller;

import com.SpringJpa.demo.controller.dto.ErroResposta;
import com.SpringJpa.demo.controller.dto.LivroDTO;
import com.SpringJpa.demo.exceptions.RegistroDuplicadoException;
import com.SpringJpa.demo.model.Livro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PostMapping
    public ResponseEntity<Object> salvarLivro(@RequestBody @Valid LivroDTO livro) {
        try {
            return ResponseEntity.ok(livro);
        } catch (RegistroDuplicadoException ex) {
            var erroDTO = ErroResposta.conflito(ex.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }
}

package com.SpringJpa.demo.controller;

import com.SpringJpa.demo.controller.dto.ErroResposta;
import com.SpringJpa.demo.controller.dto.LivroDTO;
import com.SpringJpa.demo.controller.dto.PesquisaLivroDTO;
import com.SpringJpa.demo.controller.mappers.LivroMapper;
import com.SpringJpa.demo.exceptions.RegistroDuplicadoException;
import com.SpringJpa.demo.model.Livro;
import com.SpringJpa.demo.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController implements GenericController{

    @Autowired
    private final LivroService service;
    @Autowired
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvarLivro(@RequestBody @Valid LivroDTO dto) {
        try {
            Livro livro = mapper.toEntity(dto);
            service.salvar(livro);
            var url = gerarHeaderLocation(livro.getId());

            return ResponseEntity.created(url).build();

        } catch (RegistroDuplicadoException ex) {
            var erroDTO = ErroResposta.conflito(ex.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<PesquisaLivroDTO> obterDETALHES(@PathVariable("id")String id ){
        return service.obterPorId(UUID.fromString(id)).map(livro -> {
            
        })
    }
}

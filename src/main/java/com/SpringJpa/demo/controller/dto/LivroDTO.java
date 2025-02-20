package com.SpringJpa.demo.controller.dto;

import com.SpringJpa.demo.model.GeneroLivro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record LivroDTO(String isbn,
                       String titulo,
                       LocalDate dataPublicacao,
                       GeneroLivro genero,
                       BigDecimal preco,
                       UUID id_autor) {
}

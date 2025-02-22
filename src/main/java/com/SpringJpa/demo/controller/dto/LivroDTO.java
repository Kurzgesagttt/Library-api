package com.SpringJpa.demo.controller.dto;

import com.SpringJpa.demo.model.GeneroLivro;
import com.SpringJpa.demo.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record LivroDTO(@ISBN @NotBlank(message = "Campo obrigatorio") String isbn,
                       @NotBlank(message = "Campo obrigatorio") String titulo,
                       @Past(message = "A data deve ser válida") LocalDate dataPublicacao,
                       GeneroLivro genero,
                       BigDecimal preco,
                       @NotNull(message = "Campo obrigatorio")  UUID idAutor) {
}

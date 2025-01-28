package com.SpringJpa.demo.dto;

import java.time.LocalDate;

public record AutorDTO(String nome,
                       LocalDate dataNascimento,
                       String nacionalidade) {
}

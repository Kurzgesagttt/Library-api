package com.SpringJpa.demo.controller.mappers;

import com.SpringJpa.demo.controller.dto.LivroDTO;
import com.SpringJpa.demo.model.Livro;
import com.SpringJpa.demo.repository.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LivroMapper {

    @Autowired
    AutorRepository autorRepository;

    @Mapping(target = "autor",expression = "java( autorRepository.findById(dto.idAutor()).orElse(null) )")
    public abstract Livro toEntity(LivroDTO dto);

}

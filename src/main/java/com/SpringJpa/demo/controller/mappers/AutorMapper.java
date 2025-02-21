package com.SpringJpa.demo.controller.mappers;

import com.SpringJpa.demo.controller.dto.AutorDTO;
import com.SpringJpa.demo.model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}

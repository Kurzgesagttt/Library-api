package io.github.cursodsousa.libraryapi.controller.mappers;

import com.SpringJpa.demo.controller.dto.LivroDTO;
import com.SpringJpa.demo.controller.dto.PesquisaLivroDTO;
import com.SpringJpa.demo.controller.mappers.AutorMapper;
import com.SpringJpa.demo.model.Livro;
import com.SpringJpa.demo.repository.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = AutorMapper.class)
public abstract class LivroMapper {

    protected AutorRepository autorRepository;

    @Autowired
    public void setAutorRepository(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Mapping(target = "autor", expression = "java(autorRepository.findById(dto.idAutor()).orElse(null))")
    public abstract Livro toEntity(LivroDTO dto);

    public abstract PesquisaLivroDTO toDTO(Livro livro);
}

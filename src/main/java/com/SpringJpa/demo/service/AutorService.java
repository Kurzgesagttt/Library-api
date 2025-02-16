package com.SpringJpa.demo.service;

import com.SpringJpa.demo.exceptions.OperacaoNaoPermitidaException;
import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.repository.AutorRepository;
import com.SpringJpa.demo.repository.LivroRepository;
import com.SpringJpa.demo.validator.AutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {


    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;
    private final AutorValidator validator;


    public AutorService(AutorRepository autorRepository, AutorValidator validator,LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
        this.validator = validator;
    }

    public Autor salvarAutor(Autor autor){
        validator.validar(autor);
        return autorRepository.save(autor);
    }

    public void atualizarAutor(Autor autor){
        if(autor.getId() == null){
            throw new IllegalArgumentException("Para atualizar é necessario o autor já esteja cadastrado");
        }
        validator.validar(autor);
        autorRepository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id){
        return autorRepository.findById(id);
    }

    public void deletar(Autor autor){
        if(possuiLivros(autor)){
            throw new OperacaoNaoPermitidaException("Autor possui livros cadastrados");
        }
        autorRepository.delete(autor);
    }

    public List<Autor> pesquisa(String nome, String nacionalidade){
        if(nome != null && nacionalidade != null){
            return autorRepository.findByNomeAndNacionalidade(nome,nacionalidade);
        }
        if(nome != null){
            return autorRepository.findByNomeQuery(nome);
        }
        if(nacionalidade != null){
            return autorRepository.findByNacionalidade(nacionalidade);
        }
        return autorRepository.findAll();
    }

    public boolean possuiLivros(Autor autor){
        return livroRepository.existsByAutor(autor);
    }
}

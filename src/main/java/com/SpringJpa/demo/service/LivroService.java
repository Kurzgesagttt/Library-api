package com.SpringJpa.demo.service;

import com.SpringJpa.demo.model.Livro;
import com.SpringJpa.demo.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;

    public Livro salvar(Livro livro){
        return repository.save(livro);
    }

    public Optional<Livro> obterPorId(UUID id) {
        return repository.findById(id);
    }

    public void deleter(Livro livro){
        repository.delete(livro);
    }

}

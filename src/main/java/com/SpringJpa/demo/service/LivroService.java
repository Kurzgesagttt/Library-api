package com.SpringJpa.demo.service;

import com.SpringJpa.demo.model.Livro;
import com.SpringJpa.demo.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;

    public Livro salvar(Livro livro){
        return repository.save(livro);
    }
}

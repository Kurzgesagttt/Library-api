package com.SpringJpa.demo.service;

import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    LivroRepository repository;

    public Autor salvarAutor(Autor data){
        return repository.save(data);
    }

}


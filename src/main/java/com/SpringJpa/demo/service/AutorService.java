package com.SpringJpa.demo.service;

import com.SpringJpa.demo.dto.AutorDTO;
import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public Autor salvarAutor(Autor autor){
        return autorRepository.save(autor);
    }

}

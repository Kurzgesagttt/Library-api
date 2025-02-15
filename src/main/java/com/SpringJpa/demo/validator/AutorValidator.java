package com.SpringJpa.demo.validator;

import com.SpringJpa.demo.exceptions.RegistroDuplicadoException;
import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidator {

    private final AutorRepository repository;

    public AutorValidator(AutorRepository repository) {
        this.repository = repository;
    }

    public void validar(Autor autor){
        if(existeAutorCadastrado(autor)){
            throw new RegistroDuplicadoException("Autor ja cadastrado");
        }
    }

    private boolean existeAutorCadastrado(Autor autor){
        Optional<Autor> autorEncontrado = repository.findByNomeAndDataNascimentoAndNacionalidade(
                autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade() );

        if(autor.getId() == null){
            return autorEncontrado.isPresent();
        }

        return autorEncontrado.isPresent() && !autor.getId().equals(autorEncontrado.get().getId());

    }


}

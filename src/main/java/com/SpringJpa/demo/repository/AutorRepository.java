package com.SpringJpa.demo.repository;

import com.SpringJpa.demo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

    List<Autor> findByNome(String nome);
    List<Autor> findByNacionalidade(String nacionalidade);
    List<Autor> findByNomeAndNacionalidade(String nome, String nacionalidade);

    @Query("select a from Autor a where a.nome like CONCAT('%', :nome, '%')")
    List<Autor> findByNomeQuery(@Param("nome") String nome);

}

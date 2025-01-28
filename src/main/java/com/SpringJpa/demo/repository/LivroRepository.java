package com.SpringJpa.demo.repository;

import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.model.GeneroLivro;
import com.SpringJpa.demo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @see LivroRepositoryTest
 */


public interface LivroRepository extends JpaRepository<Livro, UUID> {
    //query method

    List<Livro> findByAutor(Autor autor);

    //vai procurar o livro que foi informado no parâmetro
    List<Livro> findByTitulo(String titulo);

    List<Livro> findByIsbn(String isbn);

    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    List<Livro> findByDataPublicacaoBetween(LocalDate inicio,LocalDate fim);

    //JPQL -> referencia as propriedades e as referencias das entidades
    @Query("Select l from Livro as l order by l.titulo,l.preco")
    List<Livro> listarLivrosOrdenado();


    /**
     * select a.* from livro l join autor a on a.id = l.id_autor;
     */
    @Query("select a from Livro as l join l.autor a ")
    List<Autor> ListarAutoresDosLivros();

    @Query("select distinct l.titulo from Livro l")
    List<String> listarNomeDiferentesLivros();

    @Query("select l from Livro l where l.genero = :genero order by :paramOrdenacao ")
    List<Livro> findByGenero(
            @Param("genero")GeneroLivro generoLivro,
            @Param("paramOrdenacao") String nomePropriedade);


    @Modifying
    @Transactional
    @Query(" delete from Livro where genero = ?1")
    void deleteByGenero(GeneroLivro genero);



}

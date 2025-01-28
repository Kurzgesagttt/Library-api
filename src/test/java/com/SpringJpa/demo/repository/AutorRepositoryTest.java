package com.SpringJpa.demo.repository;

import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.model.GeneroLivro;
import com.SpringJpa.demo.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTeste(){
        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("Francesa");
        autor.setDataNascimento(LocalDate.of(1951,1,31));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo "+ autorSalvo);
    }

    @Test
    public void atualizarTeste(){
        var id = UUID.fromString("0d47f2c7-0551-4e8a-bd0e-d08ce08eb41b");

        Optional<Autor> possivelAutor = repository.findById(id);

        if(possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();

            System.out.println("Dados do autor");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1960,1,30));

            repository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTest(){
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTeste(){
        System.out.println("Contagem de autores " + repository.count());
    }

    @Test
    public void deletePorIdTeste(){
        var id = UUID.fromString("0d47f2c7-0551-4e8a-bd0e-d08ce08eb41b");
        repository.deleteById(id);
    }

    @Test
    public void deleteTeste(){
        var id = UUID.fromString("3eb98392-13d0-447f-9d13-822dee810c1f");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }

    @Test
    void salvarAutorComLivroTeste(){
        Autor autor = new Autor();
        autor.setNome("cleber");
        autor.setNacionalidade("frances");
        autor.setDataNascimento(LocalDate.of(1989,10,23));

        Livro livro = new Livro();
        livro.setIsbn("55555-66668");
        livro.setPreco(BigDecimal.valueOf(300));
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setTitulo("Einsten");
        livro.setDataPublicacao(LocalDate.of(1999,3,2));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("333333-66667");
        livro2.setPreco(BigDecimal.valueOf(30));
        livro2.setGenero(GeneroLivro.ROMANCE);
        livro2.setTitulo("Dracula");
        livro2.setDataPublicacao(LocalDate.of(1999,3,2));
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);
        //livroRepository.saveAll(autor.getLivros());

    }
    @Test
    void listarLivroAutor(){
        var id = UUID.fromString("70b45c61-b13e-4325-87a3-a78105ac8611");
        var autor = repository.findById(id).get();

        List<Livro> livroLista =  livroRepository.findByAutor(autor);
        autor.setLivros((livroLista));

        autor.getLivros().forEach(System.out::println);

    }

    @Test
    void buscaAutorPorNome(){
        List<Autor> lista = repository.findByNome("Francisca");
        lista.forEach(System.out::println);

        List<Livro> listaLivro = livroRepository.findByAutor();
        listaLivro.forEach(System.out::println);


    }



}

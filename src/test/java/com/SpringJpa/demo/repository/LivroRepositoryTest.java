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
import java.util.List;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTeste(){
        Livro livro = new Livro();
        livro.setIsbn("99989-123132");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980,1,2));
        Autor autor = autorRepository.
                findById(UUID.fromString("475b4652-5740-4c18-aa68-b97d760fcaf4")).orElse(null);

        livro.setAutor(autor);
        livroRepository.save(livro);
    }

    @Test
    void salvarCascadeTeste(){
        Livro livro = new Livro();
        livro.setIsbn("99989-12332222");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Interstellas");
        livro.setDataPublicacao(LocalDate.of(1981,1,2));

        Autor autor = new Autor();
        autor.setNome("Cleber Rosangelo");
        autor.setNacionalidade("Americano");
        autor.setDataNascimento(LocalDate.of(1951,1,31));

        livro.setAutor(autor);

        livroRepository.save(livro);
    }

    @Test
    void salvarAutorELivroTeste(){
        Livro livro = new Livro();
        livro.setIsbn("99989-66667");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("A culpa é das estrelas");
        livro.setDataPublicacao(LocalDate.of(1980,1,2));

        Autor autor = new Autor();
        autor.setNome("Miguel");
        autor.setNacionalidade("Latino");
        autor.setDataNascimento(LocalDate.of(1961,3,31));

        autorRepository.save(autor);

        livro.setAutor(autor);

        livroRepository.save(livro);
    }

    @Test
    void atualizaAutorDoLivro(){
       UUID id = UUID.fromString("eea82b44-d1c7-4a3f-81aa-07ca0734cc48");
       var livroParaAtualizar = livroRepository.findById(id).orElse(null);

        UUID idAutor = UUID.fromString("1821c192-bb20-4b5e-aff4-2c08af604e4e");
        Autor autor = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(autor);

        livroRepository.save(livroParaAtualizar);

    }

    @Test
    void deletarTeste(){
        UUID id = UUID.fromString("eea82b44-d1c7-4a3f-81aa-07ca0734cc48");
        livroRepository.deleteById(id);
    }

    @Test
    void deletarCascadeTeste(){
        UUID id = UUID.fromString("4e43f135-86a2-48a8-8365-eab304d8923b");
        livroRepository.deleteById(id);
    }

    @Test
    @Transactional
    void buscarLivroTest(){
        UUID id = UUID.fromString("d1b92454-9164-410d-9794-b9895b59b2b6");
        Livro livro = livroRepository.findById(id).orElse(null);

        System.out.println("Livro");
        System.out.println(livro.getTitulo());

        System.out.println("Autor");
        System.out.println(livro.getAutor().getNome());
    }

    @Test
    void pesquisarPorTituloTest(){
        List<Livro> lista = livroRepository.findByTitulo("Oppenheimer");
        lista.forEach(System.out::println);

    }

    @Test
    void pesquisaPorIsbnTest(){
        List<Livro> lista = livroRepository.findByIsbn("55555-66668");
        lista.forEach(System.out::println);
    }
    @Test
    void listaLivroQueryTest(){
        List<Livro> lista = livroRepository.listarLivrosOrdenado();
        lista.forEach(System.out::println);

    }

    @Test
    void listaAutorDosLivros(){
        var resultado = livroRepository.ListarAutoresDosLivros();
        resultado.forEach(System.out::println);

    }

    @Test
    void listarNomesDiferentesLivros(){
        var resultado = livroRepository.listarNomeDiferentesLivros();
        resultado.forEach(System.out::println);
    }

    @Test
    void listaPorGeneroTestQParam(){
        var resultado = livroRepository.findByGenero(GeneroLivro.FICCAO,"preco");
        resultado.forEach(System.out::println);

    }

    @Test
    void deletePorGenero(){
        livroRepository.deleteByGenero(GeneroLivro.BIOGRAFIA);
    }
}
package com.SpringJpa.demo.service;

import com.SpringJpa.demo.model.Autor;
import com.SpringJpa.demo.model.GeneroLivro;
import com.SpringJpa.demo.model.Livro;
import com.SpringJpa.demo.repository.AutorRepository;
import com.SpringJpa.demo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Transactional
    public void salvarLivroComFoto(){
        //salva o livro

        //pega id = livro.getId();
        //var id = livro.getId();


        // salvar foto do livro -> bukcet na nuvem
        //bucket é um repositorio q guarda midia na nuvem
        // bucketService.savar(livro.getFoto(),id + ".png");
        // livro.setNomeArquivoFoto(id+ ".png");
    }

    @Transactional
    public void atualizacaoSemAtualizar(){
        var livro = livroRepository.findById(UUID
                        .fromString("01422cc9-cd97-406c-a542-d6109348abd6"))
                .orElse(null);

        livro.setDataPublicacao(LocalDate.of(2004,03,30));
    }

    @Transactional
    public void executar(){
        //salva autor
        Autor autor = new Autor();
        autor.setNome("Francisco");
        autor.setNacionalidade("Latino");
        autor.setDataNascimento(LocalDate.of(1961,3,31));
        autorRepository.save(autor);

        //salva livro

        Livro livro = new Livro();
        livro.setIsbn("99989-66667");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("livro da francisco");
        livro.setDataPublicacao(LocalDate.of(1980,1,2));
        livro.setAutor(autor);

        livroRepository.save(livro);

        if(autor.getNome().equals("Francisco")){
            throw new RuntimeException("Rollback");
        }
    }

}

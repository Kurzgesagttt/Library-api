package com.SpringJpa.demo.repository;

import com.SpringJpa.demo.service.TransacaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransacoesTest {

    @Autowired
    TransacaoService service;
    /**
     * commit-> confirmar as alteracoes
     * rollback -> desfazer as alteracoes
     */
    @Test
    void transacaoSImples(){
        service.executar();
    }

    @Test
    void transacaoEstadoManaged(){
        service.atualizacaoSemAtualizar();
    }
}

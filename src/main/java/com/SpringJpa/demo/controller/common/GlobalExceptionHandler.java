package com.SpringJpa.demo.controller.common;

import com.SpringJpa.demo.controller.dto.ErroResposta;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroResposta handleMethodNotValidException(MethodArgumentNotValidException ex){
        return ErroResposta.respostaPadrao("Erro validacao");
    }
}

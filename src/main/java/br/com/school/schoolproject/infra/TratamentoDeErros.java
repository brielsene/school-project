package br.com.school.schoolproject.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<String>tratamentoDeExceptions(ValidacaoException ex){
        String mensagem = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);

    }
}

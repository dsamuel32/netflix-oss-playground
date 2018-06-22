package br.com.netflixossplaygrond.filme.exceptions.response;

import br.com.netflixossplaygrond.filme.dominio.dto.Erro;
import br.com.netflixossplaygrond.filme.exceptions.FilmeNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
@RestController
public class FilmeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FilmeNaoEncontradoException.class)
    public final ResponseEntity<Erro> handleUserNotFoundException(FilmeNaoEncontradoException ex, WebRequest request) {
        Erro errorDetails = new Erro(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Erro> handleUserNotFoundException(Exception ex, WebRequest request) {
        Erro errorDetails = new Erro(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

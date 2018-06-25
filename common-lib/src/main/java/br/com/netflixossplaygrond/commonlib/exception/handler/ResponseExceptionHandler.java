package br.com.netflixossplaygrond.commonlib.exception.handler;

import br.com.netflixossplaygrond.commonlib.dominio.DetalheErro;
import br.com.netflixossplaygrond.commonlib.exception.SemResultadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<DetalheErro> handleUserNotFoundException(Exception ex, WebRequest request) {
        DetalheErro detalheErro = new DetalheErro(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalheErro, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SemResultadoException.class)
    public final ResponseEntity<DetalheErro> handleUserNotFoundException(SemResultadoException ex, WebRequest request) {
        DetalheErro detalheErro = new DetalheErro(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(detalheErro, HttpStatus.NOT_FOUND);
    }
}

package br.com.netflixossplaygrond.filme.exception.handler;

import br.com.netflixossplaygrond.commonlib.exception.handler.ResponseExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class FilmeResponseExceptionHandler extends ResponseExceptionHandler {

}

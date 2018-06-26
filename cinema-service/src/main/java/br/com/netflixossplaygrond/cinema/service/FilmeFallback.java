package br.com.netflixossplaygrond.cinema.service;

import br.com.netflixossplaygrond.cinema.dominio.dto.FilmeDTO;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class FilmeFallback implements FilmeServiceProxy {

    @Override
    public List<FilmeDTO> getFilmes() {
        return Collections.emptyList();
    }

}

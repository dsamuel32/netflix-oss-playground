package br.com.netflixossplaygrond.cinema.service;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
public class FilmeFallback implements FilmeServiceProxy {

    @Override
    public Set<String> getFilmes() {
        return Collections.emptySet();
    }

}

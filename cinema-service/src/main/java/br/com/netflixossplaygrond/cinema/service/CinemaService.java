package br.com.netflixossplaygrond.cinema.service;

import br.com.netflixossplaygrond.cinema.domain.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CinemaService {

    @Autowired
    private FilmeServiceProxy filmeServiceProxy;

    public List<Cinema> getCinemas() {
        Cinema cinema1 = new Cinema(1L, "Cine Mark");
        cinema1.setFilmes(filmeServiceProxy.getFilmes());
        Cinema cinema2 = new Cinema(2L, "kinoplex");
        cinema2.setFilmes(filmeServiceProxy.getFilmes());

        return Arrays.asList(cinema1, cinema2);
    }
}

package br.com.netflixossplaygrond.cinema.apresentacao;

import br.com.netflixossplaygrond.cinema.dominio.dto.CinemaDTO;
import br.com.netflixossplaygrond.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "cinema", produces = MediaType.APPLICATION_JSON_VALUE)
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    public List<CinemaDTO> getCinemas() {
        return cinemaService.getCinemas();
    }

}

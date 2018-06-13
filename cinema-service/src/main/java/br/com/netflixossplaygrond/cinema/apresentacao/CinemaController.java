package br.com.netflixossplaygrond.cinema.apresentacao;

import br.com.netflixossplaygrond.cinema.domain.Cinema;
import br.com.netflixossplaygrond.cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "cinema", produces = MediaType.APPLICATION_JSON_VALUE)
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping()
    public ResponseEntity<List<Cinema>> getCinemas() {
        return new ResponseEntity<>(cinemaService.getCinemas(), HttpStatus.OK);
    }

}

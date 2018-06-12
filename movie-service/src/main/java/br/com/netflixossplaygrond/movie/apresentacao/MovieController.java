package br.com.netflixossplaygrond.movie.apresentacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "movie", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    @GetMapping()
    public ResponseEntity<Set<String>> getMovie() {
        Set<String> movies = new HashSet<>();
        movies.add("Vingadores Guerra Infinita");
        movies.add("Spider-man");
        movies.add("Home de ferro");
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

}

package br.com.netflixossplaygrond.filme.apresentacao;

import br.com.netflixossplaygrond.filme.dominio.dto.FilmeDTO;
import br.com.netflixossplaygrond.filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "filme", produces = MediaType.APPLICATION_JSON_VALUE)
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FilmeDTO> getFilmes() {
        return filmeService.findAll();
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmeDTO getFilmesPorId(@PathVariable(value = "id", required = true) Long id) {
        return filmeService.findOne(id);
    }

    @GetMapping(params = "ids")
    @ResponseStatus(HttpStatus.OK)
    public List<FilmeDTO> getFilmesPorIds(@RequestParam("ids") String params) {
        if (params != null) {
            List<Long> ids = new ArrayList<>();
            String [] parametros = params.split(";");

            for (String param : parametros) {
                ids.add(Long.valueOf(param));
            }

            return filmeService.getFilmesByIds(ids);
        }
        return Collections.emptyList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public FilmeDTO salvar(FilmeDTO filmeDTO) {
        return filmeService.salvar(filmeDTO);
    }

    @PutMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmeDTO alterar(FilmeDTO filmeDTO) {
        return filmeService.alterar(filmeDTO);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void apagar(@PathVariable(value = "id", required = true) Long id) {
        filmeService.apagar(id);
    }

}

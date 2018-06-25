package br.com.netflixossplaygrond.filme.apresentacao;

import br.com.netflixossplaygrond.filme.dominio.dto.FilmeDTO;
import br.com.netflixossplaygrond.filme.service.FilmeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "filme", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "filme", description = "Filme" )
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<FilmeDTO> getFilmes() {
        return filmeService.findAll();
    }

    @GetMapping(value = "{id}")
    @ApiOperation(
            value = "Recupera o filme de acordo com o id informado",
            notes = "Recupera o filme de acordo com o id informado",
            response = FilmeDTO.class
    )
    @ApiResponses( {
            @ApiResponse( code = 400, message = "Paramentro invalido" ),
    } )
    public FilmeDTO getFilmesPorId(@PathVariable(value = "id", required = true) Long id) {
        return filmeService.findOne(id);
    }

    @GetMapping(params = "ids")
    @ApiOperation(
            value = "Recupera uma lista de filmes de acordo com os ids informados",
            notes = "Recupera uma lista de filmes de acordo com os ids informados",
            response = List.class
    )
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
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(
            value = "Salva um novo filme",
            notes = "Salva um novo filme",
            response = FilmeDTO.class
    )
    public FilmeDTO salvar(@RequestBody FilmeDTO filmeDTO) {
        return filmeService.salvar(filmeDTO);
    }

    @PutMapping(value = "{id}")
    @ApiOperation(
            value = "Atualiza o filme informado",
            notes = "Atualiza o filme informado",
            response = FilmeDTO.class
    )
    public FilmeDTO alterar(@RequestBody FilmeDTO filmeDTO) {
        return filmeService.alterar(filmeDTO);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(
            value = "Deleta o filme informado",
            notes = "Deleta o filme informado",
            response = FilmeDTO.class
    )
    public void apagar(@PathVariable(value = "id", required = true) Long id) {
        filmeService.apagar(id);
    }

}

//http://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services

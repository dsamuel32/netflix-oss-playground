package br.com.netflixossplaygrond.cinema.apresentacao;

import br.com.netflixossplaygrond.cinema.dominio.dto.CinemaDTO;
import br.com.netflixossplaygrond.cinema.service.CinemaService;
import br.com.netflixossplaygrond.commonlib.dominio.DetalheErro;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "cinema", produces = MediaType.APPLICATION_JSON_VALUE)
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping
    @ApiOperation(
            value = "Recupera todos os filmes",
            notes = "Recupera todos os filmes",
            response = CinemaDTO.class
    )
    @ApiResponses( {
            @ApiResponse( code = 500, message = "Erro inesperado", response = DetalheErro.class)
    } )
    @ResponseStatus(HttpStatus.OK)
    public List<CinemaDTO> getCinemas() {
        return cinemaService.getCinemas();
    }

    @GetMapping(value = "{id}")
    @ApiOperation(
            value = "Recupera o cinema de acordo o id informado",
            notes = "Recupera o cinema de acordo com o id informado",
            response = CinemaDTO.class
    )
    @ApiResponses( {
            @ApiResponse( code = 400, message = "Paramentro invalido", response = DetalheErro.class),
            @ApiResponse( code = 500, message = "Erro inesperado", response = DetalheErro.class)
    } )
    @ResponseStatus(HttpStatus.OK)
    public CinemaDTO getById(@PathVariable(value = "id", required = true) Long id) {
        return cinemaService.findOne(id);
    }

    @PostMapping
    @ApiOperation(
            value = "Salva um cinema novo",
            notes = "Salva um cinema novo",
            response = CinemaDTO.class
    )
    @ApiResponses( {
            @ApiResponse( code = 400, message = "Paramentro invalido", response = DetalheErro.class),
            @ApiResponse( code = 500, message = "Erro inesperado", response = DetalheErro.class)
    } )
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaDTO salvar(@RequestBody CinemaDTO cinemaDTO) {
        return cinemaService.salvar(cinemaDTO);
    }

    @PutMapping("{id}")
    @ApiOperation(
            value = "Altera o cinema informado",
            notes = "Altera o cinema informado",
            response = CinemaDTO.class
    )
    @ApiResponses( {
            @ApiResponse( code = 400, message = "Paramentro invalido", response = DetalheErro.class),
            @ApiResponse( code = 500, message = "Erro inesperado", response = DetalheErro.class)
    } )
    @ResponseStatus(HttpStatus.CREATED)
    public CinemaDTO alterar(@PathVariable(value = "id", required = true) Long id, @RequestBody CinemaDTO cinemaDTO) {
        return cinemaService.alterar(cinemaDTO);
    }

    @DeleteMapping("{id}")
    @ApiOperation(
            value = "Apaga o cinema de acordo o id informado",
            notes = "Apaga o cinema de acordo o id informado",
            response = CinemaDTO.class
    )
    @ApiResponses( {
            @ApiResponse( code = 400, message = "Paramentro invalido", response = DetalheErro.class),
            @ApiResponse( code = 500, message = "Erro inesperado", response = DetalheErro.class)
    } )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable(value = "id", required = true) Long id) {
        cinemaService.apagar(id);
    }

}

package br.com.netflixossplaygrond.cinema.service;

import br.com.netflixossplaygrond.cinema.dominio.dto.FilmeDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "api-gateway", fallback = FilmeFallback.class)
@RibbonClient(name = "filme-service")
public interface FilmeServiceProxy {

    @GetMapping("/filme-service/filme")
    List<FilmeDTO> getFilmes();

    @GetMapping("/filme-service/filme")
    List<FilmeDTO> getFilmesPorIds(@RequestParam("ids") String params);

}

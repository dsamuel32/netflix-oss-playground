package br.com.netflixossplaygrond.cinema.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(name = "api-gateway", fallback = FilmeFallback.class)
@RibbonClient(name = "filme-service")
public interface FilmeServiceProxy {

    @GetMapping("/filme-service/filme")
    Set<String> getFilmes();

}

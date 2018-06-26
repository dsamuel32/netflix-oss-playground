package br.com.netflixossplaygrond.cinema.service.impl;

import br.com.netflixossplaygrond.cinema.dominio.dto.CinemaDTO;
import br.com.netflixossplaygrond.cinema.dominio.dto.FilmeDTO;
import br.com.netflixossplaygrond.cinema.dominio.entidade.Cinema;
import br.com.netflixossplaygrond.cinema.dominio.entidade.Exibicao;
import br.com.netflixossplaygrond.cinema.repository.CinemaRepository;
import br.com.netflixossplaygrond.cinema.service.CinemaService;
import br.com.netflixossplaygrond.cinema.service.FilmeServiceProxy;
import br.com.netflixossplaygrond.commonlib.util.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private FilmeServiceProxy filmeServiceProxy;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    public List<CinemaDTO> getCinemas() {
        List<Cinema> cinemas = cinemaRepository.findAll();
        List<CinemaDTO> cinemasDTOs = new ArrayList<>();
        ModelMapperConverter modelMapperConverter = ModelMapperConverter.getInstance();

        for (Cinema cinema : cinemas) {
            CinemaDTO cinemaDTO = modelMapperConverter.converterStrict(cinema, CinemaDTO.class);
            cinemaDTO.setFilmes(recuperarFilmes(cinema.getExibicoes()));
            cinemasDTOs.add(cinemaDTO);
        }
        return cinemasDTOs;
    }

    private List<FilmeDTO> recuperarFilmes(List<Exibicao> exibicoes) {

        if (!exibicoes.isEmpty()) {
            Set<Long> idsFilmes = exibicoes.stream().map(c -> c.getId()).collect(Collectors.toSet());
            String parametros = formataParametrosRequisicaoFilmes(idsFilmes);
            return filmeServiceProxy.getFilmesPorIds(parametros);
        }

        return Collections.emptyList();
    }

    private String formataParametrosRequisicaoFilmes(Set<Long> idsFilmes) {
        StringBuilder ids = new StringBuilder();
        if (!idsFilmes.isEmpty()) {
            idsFilmes.forEach(id -> ids.append(id).append(";"));
        }
        return ids.toString();
    }

}

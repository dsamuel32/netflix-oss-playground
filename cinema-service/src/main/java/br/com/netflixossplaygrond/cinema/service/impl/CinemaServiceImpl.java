package br.com.netflixossplaygrond.cinema.service.impl;

import br.com.netflixossplaygrond.cinema.dominio.dto.CinemaDTO;
import br.com.netflixossplaygrond.cinema.dominio.entidade.Cinema;
import br.com.netflixossplaygrond.cinema.dominio.entidade.Exibicao;
import br.com.netflixossplaygrond.cinema.repository.CinemaRepository;
import br.com.netflixossplaygrond.cinema.service.CinemaService;
import br.com.netflixossplaygrond.cinema.service.integracao.FilmeIntegracao;
import br.com.netflixossplaygrond.commonlib.exception.SemResultadoException;
import br.com.netflixossplaygrond.commonlib.util.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private FilmeIntegracao filmeIntegracao;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Override
    public List<CinemaDTO> getCinemas() {
        List<Cinema> cinemas = cinemaRepository.findAll();
        List<CinemaDTO> cinemasDTOs = new ArrayList<>();
        ModelMapperConverter modelMapperConverter = ModelMapperConverter.getInstance();

        for (Cinema cinema : cinemas) {
            CinemaDTO cinemaDTO = modelMapperConverter.converterStrict(cinema, CinemaDTO.class);
            Set<Long> idsFilmes = formatarParametros(cinema.getExibicoes());
            cinemaDTO.setFilmes(filmeIntegracao.recuperarFilmes(idsFilmes));
            cinemasDTOs.add(cinemaDTO);
        }
        return cinemasDTOs;
    }

    @Override
    public CinemaDTO findOne(Long id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(() -> new SemResultadoException("cinema", "id", id));
        CinemaDTO cinemaDTO = ModelMapperConverter.getInstance().converterStrict(cinema, CinemaDTO.class);
        Set<Long> idsFilmes = formatarParametros(cinema.getExibicoes());
        cinemaDTO.setFilmes(filmeIntegracao.recuperarFilmes(idsFilmes));
        return cinemaDTO;
    }

    @Override
    public CinemaDTO salvar(CinemaDTO cinemaDTO) {
        ModelMapperConverter modelMapperConverter = ModelMapperConverter.getInstance();
        Cinema cinema = modelMapperConverter.converterStrict(cinemaDTO, Cinema.class);
        cinema = cinemaRepository.save(cinema);
        CinemaDTO cinemaDTOSalvo = modelMapperConverter.converterStrict(cinema, CinemaDTO.class);
        Set<Long> idsFilmes = formatarParametros(cinema.getExibicoes());
        cinemaDTO.setFilmes(filmeIntegracao.recuperarFilmes(idsFilmes));
        return cinemaDTOSalvo;
    }

    @Override
    public CinemaDTO alterar(CinemaDTO cinemaDTO) {
        return salvar(cinemaDTO);
    }

    @Override
    public void apagar(Long id) {
        cinemaRepository.deleteById(id);
    }

    private Set<Long> formatarParametros(List<Exibicao> exibicoes) {
        if (!exibicoes.isEmpty()) {
            return exibicoes.stream().map(c -> c.getCodigoFilme()).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

}

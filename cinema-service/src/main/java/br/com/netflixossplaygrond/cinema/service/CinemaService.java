package br.com.netflixossplaygrond.cinema.service;

import br.com.netflixossplaygrond.cinema.dominio.dto.CinemaDTO;

import java.util.List;

public interface CinemaService {

    List<CinemaDTO> getCinemas();

    CinemaDTO findOne(Long id);

    CinemaDTO salvar(CinemaDTO cinemaDTO);

    CinemaDTO alterar(CinemaDTO cinemaDTO);

    void apagar(Long id);

}

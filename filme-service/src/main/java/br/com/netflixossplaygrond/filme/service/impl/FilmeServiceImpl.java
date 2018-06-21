package br.com.netflixossplaygrond.filme.service.impl;

import br.com.netflixossplaygrond.commonlib.util.ModelMapperConverter;
import br.com.netflixossplaygrond.filme.dominio.entidade.Filme;
import br.com.netflixossplaygrond.filme.dominio.dto.FilmeDTO;
import br.com.netflixossplaygrond.filme.repository.FilmeRepository;
import br.com.netflixossplaygrond.filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeServiceImpl implements FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;


    @Override
    public FilmeDTO findOne(Long id) {
        Optional<Filme> optional = filmeRepository.findById(id);

        if (optional.isPresent()) {
            return ModelMapperConverter.getInstance().converterStrict(optional.get(), FilmeDTO.class);
        }

        return new FilmeDTO();
    }

    @Override
    public List<FilmeDTO> findAll() {
        List<Filme> filmes = filmeRepository.findAll();
        return converterFilmesToFilmeDTO(filmes);
    }

    @Override
    public List<FilmeDTO> getFilmesByIds(List<Long> ids) {
        List<Filme> filmes = filmeRepository.findFilmesByIds(ids);
        return converterFilmesToFilmeDTO(filmes);
    }

    private List<FilmeDTO> converterFilmesToFilmeDTO(List<Filme> filmes) {
        if (!filmes.isEmpty()) {
            List<FilmeDTO> filmesDTOs = new ArrayList<>();
            ModelMapperConverter modelMapperConverter = ModelMapperConverter.getInstance();
            filmes.forEach(filme -> {
                FilmeDTO filmeDTO = modelMapperConverter.converterStrict(filme, FilmeDTO.class);
                filmesDTOs.add(filmeDTO);
            });
            return filmesDTOs;
        }
        return Collections.emptyList();
    }

}

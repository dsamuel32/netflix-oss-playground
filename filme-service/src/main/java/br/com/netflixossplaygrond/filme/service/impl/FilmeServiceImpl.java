package br.com.netflixossplaygrond.filme.service.impl;

import br.com.netflixossplaygrond.commonlib.util.ModelMapperConverter;
import br.com.netflixossplaygrond.filme.dominio.dto.FilmeDTO;
import br.com.netflixossplaygrond.filme.dominio.entidade.Filme;
import br.com.netflixossplaygrond.filme.exceptions.FilmeNaoEncontradoException;
import br.com.netflixossplaygrond.filme.repository.FilmeRepository;
import br.com.netflixossplaygrond.filme.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FilmeServiceImpl implements FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    public FilmeDTO findOne(Long id) {
        Filme filme =
                filmeRepository.findById(id)
                               .orElseThrow(() -> new FilmeNaoEncontradoException("Filme", "id", id));
        return ModelMapperConverter.getInstance().converterStrict(filme, FilmeDTO.class);
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public FilmeDTO salvar(FilmeDTO filmeDTO) {
        ModelMapperConverter modelMapperConverter = ModelMapperConverter.getInstance();
        Filme filme = modelMapperConverter.converterStrict(filmeDTO, Filme.class);
        filme = filmeRepository.save(filme);
        return modelMapperConverter.converterStrict(filme, FilmeDTO.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public FilmeDTO alterar(FilmeDTO filmeDTO) {
        return salvar(filmeDTO);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void apagar(Long id) {
        filmeRepository.deleteById(id);
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

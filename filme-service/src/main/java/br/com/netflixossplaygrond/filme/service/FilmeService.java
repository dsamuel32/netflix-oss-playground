package br.com.netflixossplaygrond.filme.service;

import br.com.netflixossplaygrond.filme.dominio.dto.FilmeDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmeService {

    FilmeDTO findOne(Long id);

    List<FilmeDTO> findAll();

    List<FilmeDTO> getFilmesByIds(@Param("ids") List<Long> ids);

    FilmeDTO salvar(FilmeDTO filmeDTO);

    FilmeDTO alterar(FilmeDTO filmeDTO);

    void apagar(Long id);



}

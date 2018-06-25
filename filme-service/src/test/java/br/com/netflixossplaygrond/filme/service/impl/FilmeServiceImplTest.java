package br.com.netflixossplaygrond.filme.service.impl;

import br.com.netflixossplaygrond.filme.dominio.dto.FilmeDTO;
import br.com.netflixossplaygrond.filme.dominio.entidade.Filme;
import br.com.netflixossplaygrond.filme.repository.FilmeRepository;
import br.com.netflixossplaygrond.filme.service.FilmeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FilmeServiceImplTest {

    @InjectMocks
    private FilmeServiceImpl filmeService;

    @Mock
    private FilmeRepository filmeRepository;

    @Mock
    private Filme filme;

    private Optional<Filme> createFilme() {
        Filme filme = new Filme();
        filme.setId(1l);
        filme.setNome("teste");
        filme.setSinopse("Sem sinopse");
        filme.setDataLancamento(LocalDate.now());
        return Optional.ofNullable(filme);
    }

    @Test
    public void findOne() {
        when(filmeRepository.findById(anyLong())).thenReturn(createFilme());
        FilmeDTO resposta = filmeService.findOne(1l);
        assertEquals(Long.valueOf(1), resposta.getId());
    }

    @Test
    public void findAll() {
        when(filmeRepository.findAll()).thenReturn(Arrays.asList(createFilme().get()));
        List<FilmeDTO> resposta = filmeService.findAll();
        assertFalse(resposta.isEmpty());
    }

    @Test
    public void findAllSemResultado() {
        when(filmeRepository.findAll()).thenReturn(Collections.emptyList());
        List<FilmeDTO> resposta = filmeService.findAll();
        assertTrue(resposta.isEmpty());
    }

    @Test
    public void getFilmesByIds() {
        when(filmeRepository.findFilmesByIds(anyList())).thenReturn(Arrays.asList(createFilme().get()));
        List<FilmeDTO> resposta = filmeService.getFilmesByIds(Arrays.asList(1L));
        assertFalse(resposta.isEmpty());
    }

    @Test
    public void salvar() {
        when(filmeRepository.save(any(Filme.class))).thenReturn(createFilme().get());
        FilmeDTO filmeSalvo = filmeService.salvar(criarFilmeDTO());
        assertNotNull(filmeSalvo.getId());
    }

    @Test
    public void alterar() {
        when(filmeRepository.save(any(Filme.class))).thenReturn(createFilme().get());
        FilmeDTO filmeSalvo = filmeService.alterar(criarFilmeDTO());
        assertNotNull(filmeSalvo.getId());
    }

    @Test
    public void apagar() {
    }

    private FilmeDTO criarFilmeDTO() {
        FilmeDTO filmeDTO = new FilmeDTO();
        filmeDTO.setNome("teste");
        filmeDTO.setSinopse("Sem sinopse");
        filmeDTO.setDataLancamento(LocalDate.now());
        return filmeDTO;
    }
}
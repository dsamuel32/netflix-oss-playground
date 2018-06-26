package br.com.netflixossplaygrond.cinema.dominio.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class FilmeDTO implements Serializable {

    private Long id;

    private String nome;

    private String sinopse;

    private LocalDate dataLancamento;

    private String urlBaner;

    private DominioDTO genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getUrlBaner() {
        return urlBaner;
    }

    public void setUrlBaner(String urlBaner) {
        this.urlBaner = urlBaner;
    }

    public DominioDTO getGenero() {
        return genero;
    }

    public void setGenero(DominioDTO genero) {
        this.genero = genero;
    }

}

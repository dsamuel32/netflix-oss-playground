package br.com.netflixossplaygrond.cinema.dominio.dto;

import java.io.Serializable;
import java.util.List;

public class CinemaDTO implements Serializable {

    private Long id;

    private String nome;

    private List<FilmeDTO> filmes;

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

    public List<FilmeDTO> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<FilmeDTO> filmes) {
        this.filmes = filmes;
    }
}

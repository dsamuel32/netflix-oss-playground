package br.com.netflixossplaygrond.cinema.domain;

import java.util.Set;

public class Cinema {

    private Long id;
    private String nome;
    private Set<String> filmes;

    public Cinema(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

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

    public Set<String> getFilmes() {
        return filmes;
    }

    public void setFilmes(Set<String> filmes) {
        this.filmes = filmes;
    }

}


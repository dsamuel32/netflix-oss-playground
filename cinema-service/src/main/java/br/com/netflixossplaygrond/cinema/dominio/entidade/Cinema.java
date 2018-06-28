package br.com.netflixossplaygrond.cinema.dominio.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_cinema", schema = "cinema")
public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cidade")
    private String cidade;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private List<Exibicao> exibicoes;

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Exibicao> getExibicoes() {
        return exibicoes;
    }

    public void setExibicoes(List<Exibicao> exibicoes) {
        this.exibicoes = exibicoes;
    }

}


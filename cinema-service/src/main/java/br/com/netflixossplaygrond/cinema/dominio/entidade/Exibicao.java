package br.com.netflixossplaygrond.cinema.dominio.entidade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_exibicao", schema = "cinema")
public class Exibicao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "co_cinema")
    private Cinema cinema;

    @Column(name = "co_filme")
    private Long codigoFilme;

    @Column(name = "dt_inicio_exibicao")
    private LocalDate inicioExibicao;

    @Column(name = "dt_fim_exibicao")
    private LocalDate fimExibicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Long getCodigoFilme() {
        return codigoFilme;
    }

    public void setCodigoFilme(Long codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    public LocalDate getInicioExibicao() {
        return inicioExibicao;
    }

    public void setInicioExibicao(LocalDate inicioExibicao) {
        this.inicioExibicao = inicioExibicao;
    }

    public LocalDate getFimExibicao() {
        return fimExibicao;
    }

    public void setFimExibicao(LocalDate fimExibicao) {
        this.fimExibicao = fimExibicao;
    }

}

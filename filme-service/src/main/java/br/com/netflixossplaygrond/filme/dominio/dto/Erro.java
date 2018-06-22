package br.com.netflixossplaygrond.filme.dominio.dto;

import java.time.LocalDate;

public class Erro {

    private LocalDate data;
    private String mensagem;
    private String detalhe;

    public Erro(LocalDate data, String mensagem, String detalhe) {
        this.data = data;
        this.mensagem = mensagem;
        this.detalhe = detalhe;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

}

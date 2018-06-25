package br.com.netflixossplaygrond.commonlib.dominio;

import java.time.LocalDate;

public class DetalheErro {

    private LocalDate data;
    private String mensagem;
    private String detalhe;

    public DetalheErro(LocalDate data, String mensagem, String detalhe) {
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

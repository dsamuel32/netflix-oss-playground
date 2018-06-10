package br.com.netflixossplaygrond.commonlib.util;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ModelMapperConverterTest {

    private ModelMapperConverter modelMapperConverter;

    @Before
    public void init() {
        this.modelMapperConverter = ModelMapperConverter.getInstance();
    }

    @Test
    public void converter() {
        Pessoa pessoa = new Pessoa(1L, "teste");
        PessoaDTO pessoaDTO = modelMapperConverter.converter(pessoa, PessoaDTO.class);
        assertThat(pessoaDTO.getId()).isEqualTo(pessoa.getId());
        assertThat(pessoaDTO.getNome()).isEqualTo(pessoa.getNome());
    }

}

class Pessoa {
    private Long id;
    private String nome;

    public Pessoa(Long id, String nome) {
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
}

class PessoaDTO {
    private Long id;
    private String nome;

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
}
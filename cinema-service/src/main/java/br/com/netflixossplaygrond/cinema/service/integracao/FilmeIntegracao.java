package br.com.netflixossplaygrond.cinema.service.integracao;

import br.com.netflixossplaygrond.cinema.dominio.dto.FilmeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
public class FilmeIntegracao {

    @Autowired
    private FilmeServiceProxy filmeServiceProxy;

    public List<FilmeDTO> recuperarFilmes(Set<Long> ids) {

        if (ids != null) {
            String parametros = formataParametrosRequisicaoFilmes(ids);
            return filmeServiceProxy.getFilmesPorIds(parametros);
        }

        return Collections.emptyList();
    }

    private String formataParametrosRequisicaoFilmes(Set<Long> idsFilmes) {
        StringBuilder ids = new StringBuilder();
        if (!idsFilmes.isEmpty()) {
            idsFilmes.forEach(id -> ids.append(id).append(";"));

        }
        return ids.toString();
    }
}

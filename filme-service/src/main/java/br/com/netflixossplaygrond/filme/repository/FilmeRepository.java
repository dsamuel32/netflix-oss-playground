package br.com.netflixossplaygrond.filme.repository;

import br.com.netflixossplaygrond.filme.dominio.entidade.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    @Query("SELECT f FROM Filme f WHERE f.id IN(:ids)")
    List<Filme> findFilmesByIds(@Param("ids") List<Long> ids);

}

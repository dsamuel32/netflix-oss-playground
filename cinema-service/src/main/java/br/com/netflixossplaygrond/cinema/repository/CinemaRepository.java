package br.com.netflixossplaygrond.cinema.repository;

import br.com.netflixossplaygrond.cinema.dominio.entidade.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}

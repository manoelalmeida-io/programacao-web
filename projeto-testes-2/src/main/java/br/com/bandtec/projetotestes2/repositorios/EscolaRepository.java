package br.com.bandtec.projetotestes2.repositorios;

import br.com.bandtec.projetotestes2.entidades.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {

  List<Escola> findByAlunosBetween(int minimo, int maximo);
}

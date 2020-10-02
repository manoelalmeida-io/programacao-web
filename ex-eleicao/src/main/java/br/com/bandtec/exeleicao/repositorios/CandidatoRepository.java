package br.com.bandtec.exeleicao.repositorios;

import br.com.bandtec.exeleicao.dominio.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {

  Integer countByValidoIsTrue();

  @Query("select c from Candidato c order by votos desc")
  List<Candidato> listarOrdenadoPorVotos();
}

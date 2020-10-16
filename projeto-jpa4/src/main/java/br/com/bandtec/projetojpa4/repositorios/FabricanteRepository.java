package br.com.bandtec.projetojpa4.repositorios;

import br.com.bandtec.projetojpa4.dominios.Fabricante;
import br.com.bandtec.projetojpa4.visoes.FabricanteSimples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {

  @Query("select f from Fabricante f")
  List<FabricanteSimples> findAllSimples();
}

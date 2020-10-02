package br.com.bandtec.projetojpa2.repositorios;

import br.com.bandtec.projetojpa2.dominio.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

  List<Animal> findByPesoGreaterThan(Double peso);

  @Query("select a from Animal a where a.peso > ?1")
  List<Animal> pesquisaPorPesoAcimaDe(Double peso);
}

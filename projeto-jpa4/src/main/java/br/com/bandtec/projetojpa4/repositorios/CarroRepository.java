package br.com.bandtec.projetojpa4.repositorios;

import br.com.bandtec.projetojpa4.dominios.Carro;
import br.com.bandtec.projetojpa4.visoes.CarroSimples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

  @Query("select new br.com.bandtec.projetojpa4.visoes.CarroSimples(c.id, c.modelo) from Carro c")
  List<CarroSimples> findAllSimples();
}

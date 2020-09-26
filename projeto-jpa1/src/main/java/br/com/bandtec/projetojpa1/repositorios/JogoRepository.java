package br.com.bandtec.projetojpa1.repositorios;

import br.com.bandtec.projetojpa1.dominios.Jogo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JogoRepository extends CrudRepository<Jogo, Integer> {

  List<Jogo> findByNome(String nome);
  List<Jogo> findByPrecoGreaterThan(Double preco);
}

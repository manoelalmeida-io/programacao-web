package br.com.bandtec.projetoagendador.repositorios;

import br.com.bandtec.projetoagendador.dominios.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

  List<Cliente> findByDiaNascimentoAndMesNascimento(Integer dia, Integer mes);
}

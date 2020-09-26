package br.com.bandtec.projeto03;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cachorros")
public class CachorroController {

  private List<Cachorro> cachorros = new ArrayList<>();

  @GetMapping("/listar")
  public List<Cachorro> getCachorros() {
    return cachorros;
  }

  @PostMapping("/cadastrar")
  public void cadastrarCachorro(@RequestBody Cachorro cachorro) {
    cachorros.add(cachorro);
  }

  @GetMapping("/recuperar/{id}")
  public Cachorro getCachorro(@PathVariable int id) {
    return cachorros.get(id - 1);
  }

  @DeleteMapping("/excluir/{id}")
  public void excluirCachorro(@PathVariable int id) {
    cachorros.remove(id - 1);
  }

  @PutMapping("/alterar/{id}")
  public void alterarCachorro(@RequestBody Cachorro cachorro, @PathVariable int id) {
    cachorros.set(id - 1, cachorro);
  }
}

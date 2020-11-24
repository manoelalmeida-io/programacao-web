package br.com.bandtec.projetotestes2.controladores;

import br.com.bandtec.projetotestes2.entidades.Escola;
import br.com.bandtec.projetotestes2.repositorios.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

  @Autowired
  private EscolaRepository repository;

  @GetMapping
  public ResponseEntity getTodos() {
    List<Escola> escolas = repository.findAll();
    return escolas.isEmpty() ? noContent().build() : ok(escolas);
  }

  @GetMapping("{id}")
  public ResponseEntity getUm(@PathVariable Integer id) {
    return of(repository.findById(id));
  }

  @DeleteMapping("{id}")
  public ResponseEntity deleteUm(@PathVariable Integer id) {
    if  (repository.existsById(id)) {
      repository.deleteById(id);
      return ok().build();
    }
    return notFound().build();
  }

  @GetMapping("{min}/{max}")
  public ResponseEntity buscar(@PathVariable Integer min, @PathVariable Integer max) {
    List<Escola> escolas = repository.findByAlunosBetween(min, max);

    if (min < 0 || max < 0) {
      return badRequest().body("parâmetros inválidos");
    }

    return escolas.isEmpty() ? noContent().build() : ok(escolas);
  }
}

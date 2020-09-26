package br.com.bandtec.projetojpa1.controladores;

import br.com.bandtec.projetojpa1.dominios.Jogo;
import br.com.bandtec.projetojpa1.repositorios.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {

  @Autowired
  private JogoRepository repository;

  @GetMapping
  public ResponseEntity pesquisar(
      @RequestParam(required = false) String nome,
      @RequestParam(required = false) Double precoMinimo
  ) {
    if (nome == null && precoMinimo == null) {
      if (repository.count() > 0) {
        return ResponseEntity.ok(repository.findAll());
      } else {
        return ResponseEntity.noContent().build();
      }
    } else {
      if (nome != null) {
        return ResponseEntity.ok(repository.findByNome(nome));
      } else {
        return ResponseEntity.ok(repository.findByPrecoGreaterThan(precoMinimo));
      }
    }
  }

  @PostMapping
  public ResponseEntity criar(@RequestBody Jogo novoJogo) {
    repository.save(novoJogo);
    return ResponseEntity.created(null).build();
  }

  @GetMapping("{id}")
  public ResponseEntity getUm(@PathVariable int id) {
    Optional<Jogo> jogoOptional = repository.findById(id);
    return ResponseEntity.of(jogoOptional);
  }

  @DeleteMapping("{id}")
  public ResponseEntity excluirUm(@PathVariable int id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("{id}")
  public ResponseEntity atualizar(@PathVariable int id, @RequestBody Jogo jogoAtualizado) {
    if (repository.existsById(id)) {
      jogoAtualizado.setId(id);
      repository.save(jogoAtualizado);

      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

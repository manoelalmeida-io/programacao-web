package br.com.bandtec.exeleicao.controladores;

import br.com.bandtec.exeleicao.dominio.Candidato;
import br.com.bandtec.exeleicao.repositorios.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("eleicoes")
public class CandidatoController {

  @Autowired
  private CandidatoRepository repository;

  @PostMapping("candidatos")
  public ResponseEntity cadastrar(@RequestBody Candidato novoCandidato) {
    novoCandidato.setVotos(0);
    repository.save(novoCandidato);
    return ResponseEntity.created(null).build();
  }

  @PostMapping("votar/{idCandidato}")
  public ResponseEntity votar(@PathVariable("idCandidato") Integer id) {
    if (!(repository.countByValidoIsTrue() > 0)) {
      return ResponseEntity.notFound().build();
    }

    Optional<Candidato> optionalVoto = repository.findById(id);

    if (optionalVoto.isPresent()) {
      Candidato candidato = optionalVoto.get();
      candidato.setVotos(candidato.getVotos() + 1);
      repository.save(candidato);

      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("resultado")
  public ResponseEntity resultado() {
    List<Candidato> resultados = repository.listarOrdenadoPorVotos();
    return ResponseEntity.ok(resultados);
  }
}

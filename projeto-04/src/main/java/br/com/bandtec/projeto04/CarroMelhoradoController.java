package br.com.bandtec.projeto04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class CarroMelhoradoController {

  private List<Carro> carros = new ArrayList<>();

  @GetMapping
  public ResponseEntity listarCarros() {
    if (carros.isEmpty()) {
      return ResponseEntity.status(204).build();
    }
    return ResponseEntity.ok(carros);
  }

  @GetMapping("/{id}")
  public ResponseEntity recuperarCarro(@PathVariable int id) {
    if (carros.size() >= id) {
      return ResponseEntity.ok(carros.get(id - 1));
    }
    return ResponseEntity.status(404).build();
  }

  @PostMapping
  public ResponseEntity criarCarro(@RequestBody Carro novoCarro) {
    carros.add(novoCarro);
    return ResponseEntity.status(201).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity excluirCarro(@PathVariable int id) {
    if (carros.size() >= id) {
      carros.remove(id - 1);
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.status(404).build();
    }
  }

  @GetMapping("/populares")
  public ResponseEntity getCarrosPopulares() {
    List<Carro> populares = carros.stream()
        .filter(carro -> carro.getPreco() < 10000)
        .collect(Collectors.toList());

    if (populares.isEmpty()) {
      return ResponseEntity.status(204).build();
    }

    return ResponseEntity.ok(populares);
  }
}

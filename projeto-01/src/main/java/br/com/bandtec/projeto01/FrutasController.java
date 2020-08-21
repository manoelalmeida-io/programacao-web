package br.com.bandtec.projeto01;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrutasController {

  List<Fruta> frutas = Arrays.asList(
      new Fruta("Abacate", 20.0),
      new Fruta("Maçã", 12.5),
      new Fruta("Pera", 8.3)
  );

  @GetMapping("/frutas")
  public List<Fruta> getFrutas() {
    return frutas;
  }
}

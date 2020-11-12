package br.com.bandtec.projetotestes1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

  @GetMapping("/salario/{salario}")
  public ResponseEntity salario(@PathVariable Double salario) {
    if (salario < 0) {
      return ResponseEntity.badRequest().body("salário inválido");
    }

    if (salario < 1500) {
      return ResponseEntity.ok(0.0);
    } else if (salario <= 3000) {
      return ResponseEntity.ok(salario * 10 / 100);
    } else {
      return ResponseEntity.ok(salario * 20 / 100);
    }
  }
}

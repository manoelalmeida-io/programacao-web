package br.com.bandtec.projetotestes1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculos")
public class CalculadoraController {

  @GetMapping("/somar/{n1}/{n2}")
  public ResponseEntity somar(@PathVariable Double n1, @PathVariable Double n2) {
    Double soma = n1 + n2;
    return ResponseEntity.ok(soma);
  }

  @GetMapping("/avaliar/{nota1}/{nota2}")
  public ResponseEntity avaliar(@PathVariable Double nota1, @PathVariable Double nota2) {
    if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
      return ResponseEntity.badRequest().body("Uma ou mais notas inválidas");
    }

    Double media = (nota1 + nota2) / 2;
    return ResponseEntity.ok(media >= 5 ? "Aprovado(a)" : "Reprovado(a)");
  }
}


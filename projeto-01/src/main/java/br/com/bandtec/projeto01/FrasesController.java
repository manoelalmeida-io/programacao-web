package br.com.bandtec.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrasesController {

  @GetMapping("/frase1")
  public String getFrase() {
    return "Minha primeira API! @@";
  }

  @GetMapping("/frase2")
  public String getFrase2() {
    return "Minha API é mó daora";
  }

  @GetMapping("/numero")
  public Integer getAnoNascimento() {
    return 456;
  }
}

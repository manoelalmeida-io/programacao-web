package br.com.bandtec.projeto02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaCorrenteController {

  private Double saldo = 0.0;
  private Integer qtdSaques = 0;
  private Integer qtdDepositos = 0;

  @GetMapping("/saldo")
  public Double getSaldo() {
    return saldo;
  }

  @GetMapping("/depositar/{valor}")
  public void depositar(@PathVariable Double valor) {
    if (valor > 0) {
      saldo += valor;
      qtdDepositos++;
    }
  }

  @GetMapping("/sacar/{valor}")
  public void sacar(@PathVariable Double valor) {
    if (saldo >= valor && valor > 0) {
      saldo -= valor;
      qtdSaques++;
    }
  }

  @GetMapping("/quantidade")
  public String quantidadeOperacoes() {
    return String.format("Foram realizados %d saques e %d depositos", qtdSaques, qtdDepositos);
  }
}

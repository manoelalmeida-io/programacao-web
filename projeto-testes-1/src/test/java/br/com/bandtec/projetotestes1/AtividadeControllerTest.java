package br.com.bandtec.projetotestes1;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class AtividadeControllerTest {

  @Test
  void salario() {
    // Cenário 1
    AtividadeController controller = new AtividadeController();
    Double salario = 1000.0;

    Double respostaEsperada = 0.0;
    Integer statusEsperado = 200;

    ResponseEntity resposta = controller.salario(salario);

    assertEquals(respostaEsperada, resposta.getBody());
    assertEquals(statusEsperado, resposta.getStatusCodeValue());

    // Cenário 2
    salario = -10.0;

    String respostaErro = "salário inválido";
    statusEsperado = 400;

    resposta = controller.salario(salario);

    assertEquals(respostaErro, resposta.getBody());
    assertEquals(statusEsperado, resposta.getStatusCodeValue());

    // Cenário 3
    salario = 1600.0;

    respostaEsperada = 160.0;
    statusEsperado = 200;

    resposta = controller.salario(salario);

    assertEquals(respostaEsperada, resposta.getBody());
    assertEquals(statusEsperado, resposta.getStatusCodeValue());

    // Cenário 4
    salario = 4000.0;

    respostaEsperada = 800.0;
    statusEsperado = 200;

    resposta = controller.salario(salario);

    assertEquals(respostaEsperada, resposta.getBody());
    assertEquals(statusEsperado, resposta.getStatusCodeValue());
  }
}
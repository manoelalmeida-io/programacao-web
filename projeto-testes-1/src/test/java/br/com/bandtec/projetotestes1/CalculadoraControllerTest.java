package br.com.bandtec.projetotestes1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraControllerTest {

  @Test
  @DisplayName("O somar() deve somar 2 números")
  void somar() {
    // Variáveis para a execução do teste
    CalculadoraController controller = new CalculadoraController();
    Double n1 = 10.0;
    Double n2 = 20.0;
    Double somaEsperada = 30.0;

    // Executando método a ser testados
    // e guardando seu resultado numa variável (resposta)
    ResponseEntity resposta = controller.somar(n1, n2);

    // Verificação se o resultado é o esperado
    assertEquals(somaEsperada, resposta.getBody());
  }

  @Test
  void avaliar() {
    // cenário 1: notas que aprovam
    Double nota1 = 9.5;
    Double nota2 = 8.0;
    String resultadoEsperado = "Aprovado(a)";
    CalculadoraController controller = new CalculadoraController();

    ResponseEntity resposta = controller.avaliar(nota1, nota2);
    assertEquals(resultadoEsperado, resposta.getBody());

    // cenário 2: notas que reprovam
    nota1 = 4.0;
    nota2 = 2.5;
    resultadoEsperado = "Reprovado(a)";

    resposta = controller.avaliar(nota1, nota2);

    assertEquals(resultadoEsperado, resposta.getBody());

    // cenário 3: 1° nota inválida
    nota1 = -9.0;
    nota2 = 3.0;
    resultadoEsperado = "Uma ou mais notas inválidas";

    resposta = controller.avaliar(nota1, nota2);

    assertEquals(resultadoEsperado, resposta.getBody());
    assertEquals(400, resposta.getStatusCodeValue());

    // cenário 4: 2° nota inválida
    nota1 = 3.0;
    nota2 = -9.0;
    resultadoEsperado = "Uma ou mais notas inválidas";

    resposta = controller.avaliar(nota1, nota2);

    assertEquals(resultadoEsperado, resposta.getBody());
    assertEquals(400, resposta.getStatusCodeValue());

    // cenário 5: ambas as notas inválidas
    nota1 = -3.0;
    nota2 = -9.0;
    resultadoEsperado = "Uma ou mais notas inválidas";

    resposta = controller.avaliar(nota1, nota2);

    assertEquals(resultadoEsperado, resposta.getBody());
    assertEquals(400, resposta.getStatusCodeValue());

    // cenário 6: ambas as notas inválidas
    nota1 = 9999.0;
    nota2 = 73.0;
    resultadoEsperado = "Uma ou mais notas inválidas";

    resposta = controller.avaliar(nota1, nota2);

    assertEquals(resultadoEsperado, resposta.getBody(), "2 valores > 10 deveria dar ruim");
    assertEquals(400, resposta.getStatusCodeValue());
  }
}

package br.com.bandtec.projetoapireactiva;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/sorteios")
public class SorteiosController {

  private final Map<UUID, Integer> sorteados = new HashMap<>();

  @GetMapping("/sortear/{numero}")
  public ResponseEntity sortear(@PathVariable int numero) {

    UUID identificador = UUID.randomUUID();

    Thread threadSorteio = new Thread() {
      @Override
      public void run() {
        for (int i = 1;; i++) {
          int pegou = ThreadLocalRandom.current().nextInt(0, 10000000);
          System.out.println("sorteado: " + pegou);
          if (pegou == numero) {
            sorteados.put(identificador, i);
            break;
          }
        }
      }
    };

    threadSorteio.start();
    return accepted()
        .header("identificador", identificador.toString())
        .header("tempo-segundos", "30")
        .build();
  }

  @GetMapping("/resultado/{identificador}")
  public ResponseEntity resultado(@PathVariable UUID identificador) {
    Integer resultado = sorteados.get(identificador);
    if (resultado == null) {
      return notFound().build();
    } else {
      return ok("Seu número foi sorteado após " + resultado + " sorteios!");
    }
  }
}

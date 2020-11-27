package br.com.bandtec.projetoagendador.servicos;

import br.com.bandtec.projetoagendador.dominios.Cliente;
import br.com.bandtec.projetoagendador.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AgendamentosService {

  @Autowired
  private ClienteRepository repository;

//  @Scheduled(fixedRate = 4000)
//  public void recitarPoesia() {
//    System.out.println("O amor é como fogo que arde sem se ver");
//  }
//
//  @Scheduled(initialDelay = 5000, fixedRate = 7000)
//  public void falarPreguicoso() {
//    System.out.println("Eaeeeeee, maaaanooooo... (ouvindo reggae)");
//  }
//
//  @Scheduled(fixedRate = 1000)
//  public void sortearNumero() {
//    System.out.println("Iniciando um sorteio...");
//    int quero = 30;
//    while (true) {
//      int sorteado = ThreadLocalRandom.current().nextInt(0, 50000000);
//      if (sorteado == quero) {
//        System.out.println("Fui sorteado");
//        break;
//      }
//    }
//  }
//
//  @Scheduled(fixedDelay = 3000)
//  public void recitarMantra() {
//    System.out.println("Só colhe quem planta");
//  }

  @Scheduled(cron = "50 * * * * ?")
  public void baterPonto() {
    System.out.println("Batendo ponto as " + LocalDateTime.now());
  }

  @Scheduled(fixedDelay = 60 * 60 * 24 * 1000)
  public void enviarEmail() {
    Integer dia = LocalDate.now().getDayOfMonth();
    Integer mes = LocalDate.now().getMonthValue();

    List<Cliente> clientes = repository.findByDiaNascimentoAndMesNascimento(dia, mes);

    for (Cliente cliente : clientes) {
      System.out.println("Enviando email p/ " + cliente.getNome());
    }
  }
}

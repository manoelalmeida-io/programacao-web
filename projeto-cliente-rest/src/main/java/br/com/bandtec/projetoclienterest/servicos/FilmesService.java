package br.com.bandtec.projetoclienterest.servicos;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.bandtec.projetoclienterest.modelos.Filme;

@FeignClient(name = "filmesapi", url = "http://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/")
public interface FilmesService {
  
  @GetMapping("/filmes")
  List<Filme> getFilmes();

  @PostMapping("/filmes")
  void postFilme(@RequestBody Filme corpo);
}

package br.com.bandtec.projetoclienterest.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bandtec.projetoclienterest.modelos.Filme;
import br.com.bandtec.projetoclienterest.modelos.RespostaCep;
import br.com.bandtec.projetoclienterest.servicos.FilmesService;
import br.com.bandtec.projetoclienterest.servicos.ViaCepService;

@RestController
@RequestMapping("/consultas")
public class ConsultasController {
  
  @Autowired
  private ViaCepService service;

  @Autowired
  private FilmesService filmesService;

  @GetMapping("/cep/{cep}")
  public ResponseEntity getCep(@PathVariable String cep) {
    RespostaCep respostaCep = service.getCep(cep);
    return ResponseEntity.ok(respostaCep);
  }

  @GetMapping("/filmes")
  public ResponseEntity getFilmes() {
    return ResponseEntity.ok(filmesService.getFilmes());
  }

  @PostMapping("/filmes")
  public ResponseEntity postFilme(@RequestBody Filme novo) {
    filmesService.postFilme(novo);
    return ResponseEntity.created(null).build();
  }
}

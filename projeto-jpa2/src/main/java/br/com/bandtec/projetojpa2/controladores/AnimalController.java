package br.com.bandtec.projetojpa2.controladores;

import br.com.bandtec.projetojpa2.dominio.Animal;
import br.com.bandtec.projetojpa2.repositorios.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

  @Autowired
  private AnimalRepository repository;

  @PostMapping
  public ResponseEntity criar(@RequestBody Animal novoAnimal) {
    repository.save(novoAnimal);
    return ResponseEntity.created(null).build();
  }

  @GetMapping
  public ResponseEntity pesquisar(@RequestParam(required = false) Double pesoMinimo) {
    if (pesoMinimo == null) {
      return ResponseEntity.ok(repository.findAll());
    } else {
      return ResponseEntity.ok(repository.pesquisaPorPesoAcimaDe(pesoMinimo));
    }
  }

  @GetMapping("filtro")
  public ResponseEntity filtrar(
      @RequestParam(required = false) String nome,
      @RequestParam(required = false) Double peso,
      @RequestParam(required = false) Integer idade
  ) {
    Animal animalPesquisa = new Animal();
    animalPesquisa.setNome(nome);
    animalPesquisa.setPeso(peso);
    animalPesquisa.setIdade(idade);

    List<Animal> resultado = repository.findAll(Example.of(animalPesquisa));

    if (resultado.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.ok(resultado);
    }
  }
}

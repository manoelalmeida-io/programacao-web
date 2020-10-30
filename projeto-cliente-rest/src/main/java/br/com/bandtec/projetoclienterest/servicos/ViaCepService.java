package br.com.bandtec.projetoclienterest.servicos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.bandtec.projetoclienterest.modelos.RespostaCep;

@FeignClient(name = "viacep", url = "https://viacep.com.br/")
public interface ViaCepService {

  @GetMapping("/ws/{cep}/json")
  RespostaCep getCep(@PathVariable String cep);
}

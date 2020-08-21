package br.com.bandtec.projeto02.controller;

import br.com.bandtec.projeto02.ItemCompra;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class ComprasController {

  List<ItemCompra> itens = new ArrayList<>();

  @GetMapping("/comprar/{item}/{valor}/{quantidade}")
  public void comprar(@PathVariable String item, @PathVariable Double valor, @PathVariable Integer quantidade) {
    itens.add(new ItemCompra(item, valor, quantidade));
  }

  @GetMapping
  public List<ItemCompra> lista() {
    return itens;
  }
}

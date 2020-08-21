package br.com.bandtec.projeto02;

public class ItemCompra {

  private String item;
  private Double valor;
  private Integer quantidade;

  public ItemCompra(String item, Double valor, Integer quantidade) {
    this.item = item;
    this.valor = valor;
    this.quantidade = quantidade;
  }

  public String getItem() {
    return item;
  }

  public Double getValor() {
    return valor;
  }

  public Integer getQuantidade() {
    return quantidade;
  }
}

package br.com.bandtec.projeto03;

public class Cachorro {

  private String raca;
  private Double precoMedio;

  public Cachorro(String raca, Double precoMedio) {
    this.raca = raca;
    this.precoMedio = precoMedio;
  }

  public String getRaca() {
    return raca;
  }

  public Double getPrecoMedio() {
    return precoMedio;
  }
}

package br.com.bandtec.projetojpa4.visoes;

public class CarroSimples {

  private Integer id;
  private String nome;

  public CarroSimples(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }
}

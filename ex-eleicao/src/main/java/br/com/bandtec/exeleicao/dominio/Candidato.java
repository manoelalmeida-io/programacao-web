package br.com.bandtec.exeleicao.dominio;

import javax.persistence.*;

@Entity
public class Candidato {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String nome;

  private String partido;
  private Integer votos;

  @Column(nullable = false)
  private Boolean valido;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getPartido() {
    return partido;
  }

  public void setPartido(String partido) {
    this.partido = partido;
  }

  public Integer getVotos() {
    return votos;
  }

  public void setVotos(Integer votos) {
    this.votos = votos;
  }

  public Boolean getValido() {
    return valido;
  }

  public void setValido(Boolean valido) {
    this.valido = valido;
  }
}

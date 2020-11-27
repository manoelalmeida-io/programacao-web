package br.com.bandtec.projetoagendador.dominios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;
  private Integer diaNascimento;
  private Integer mesNascimento;

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

  public Integer getDiaNascimento() {
    return diaNascimento;
  }

  public void setDiaNascimento(Integer diaNascimento) {
    this.diaNascimento = diaNascimento;
  }

  public Integer getMesNascimento() {
    return mesNascimento;
  }

  public void setMesNascimento(Integer mesNascimento) {
    this.mesNascimento = mesNascimento;
  }
}

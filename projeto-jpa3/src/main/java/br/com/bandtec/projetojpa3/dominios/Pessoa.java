package br.com.bandtec.projetojpa3.dominios;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class Pessoa {

  @NotNull
  @Length(min = 2, max = 40)
  private String nome;

  @Min(0)
  @Max(25)
  private Integer filhos;

  @Past
  private LocalDate nascimento;

  public Pessoa(String nome, Integer filhos, LocalDate nacimento) {
    this.nome = nome;
    this.filhos = filhos;
    this.nascimento = nacimento;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getFilhos() {
    return filhos;
  }

  public void setFilhos(Integer filhos) {
    this.filhos = filhos;
  }

  public LocalDate getNascimento() {
    return nascimento;
  }

  public void setNascimento(LocalDate nacimento) {
    this.nascimento = nacimento;
  }
}

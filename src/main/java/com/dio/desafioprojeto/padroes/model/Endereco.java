package com.dio.desafioprojeto.padroes.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String cep;
  private String logradouro;
  private String complemento;
  private String bairro;
  private String localidade;
  private String uf;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bairro, cep, complemento, id, localidade, logradouro, uf);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Endereco other = (Endereco) obj;
    return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
        && Objects.equals(complemento, other.complemento) && Objects.equals(id, other.id)
        && Objects.equals(localidade, other.localidade)
        && Objects.equals(logradouro, other.logradouro) && Objects.equals(uf, other.uf);
  }

  @Override
  public String toString() {
    return "Endereco [id=" + id + ", cep=" + cep + ", bairro=" + bairro + ", localidade="
        + localidade + ", uf=" + uf + "]";
  }
}
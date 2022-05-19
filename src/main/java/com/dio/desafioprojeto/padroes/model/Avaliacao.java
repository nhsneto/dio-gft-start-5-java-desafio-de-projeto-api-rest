package com.dio.desafioprojeto.padroes.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avaliacao {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String produto;
  private String comentario;
  private int estrelas;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String comentario) {
    this.comentario = comentario;
  }

  public int getEstrelas() {
    return estrelas;
  }

  public void setEstrelas(int estrelas) {
    this.estrelas = estrelas;
  }

  @Override
  public int hashCode() {
    return Objects.hash(comentario, estrelas, id, produto);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Avaliacao other = (Avaliacao) obj;
    return Objects.equals(comentario, other.comentario) && estrelas == other.estrelas
        && Objects.equals(id, other.id) && Objects.equals(produto, other.produto);
  }

  @Override
  public String toString() {
    return "Avaliacao [id=" + id + ", produto=" + produto + ", estrelas=" + estrelas + "]";
  }
}
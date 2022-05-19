package com.dio.desafioprojeto.padroes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String nome;
  private String cpf;
  private String email;
  private String telefone;
  @ManyToOne
  private Endereco endereco;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Avaliacao> avaliacoes;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String celular) {
    this.telefone = celular;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public List<Avaliacao> getAvaliacoes() {
    return avaliacoes;
  }

  public void setAvaliacoes(List<Avaliacao> avaliacoes) {
    this.avaliacoes = avaliacoes;
  }

  public void adicionaAvaliacao(Avaliacao avaliacao) {
    if (avaliacoes == null)
      avaliacoes = new ArrayList<>();
    avaliacoes.add(avaliacao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(avaliacoes, telefone, cpf, email, endereco, id, nome);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cliente other = (Cliente) obj;
    return Objects.equals(avaliacoes, other.avaliacoes) && Objects.equals(telefone, other.telefone)
        && Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
        && Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
        && Objects.equals(nome, other.nome);
  }

  @Override
  public String toString() {
    return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
  }
}
package com.dio.desafioprojeto.padroes.business;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dio.desafioprojeto.padroes.model.Cliente;

public class ClienteValidadorTest {

  private Cliente cliente;
  
  @BeforeEach
  public void setUp() {
    cliente = new Cliente();
    cliente.setId(1L);
    cliente.setNome("Cliente");
    cliente.setCpf("12345678901");
    cliente.setEmail("cliente@teste.com");
    cliente.setTelefone("81900000000");
  }
  
  @Test
  public void clienteValido() {
    assertTrue(ClienteValidador.isValido(cliente));
  }
  
  @Test
  public void falhaAoValidarClienteComCpfInvalido() {
    cliente.setCpf("1234");
    assertFalse(ClienteValidador.isValido(cliente));
  }
  
  @Test
  public void falhaAoValidarClienteComEmailInvalido() {
    cliente.setEmail("@teste.47");
    assertFalse(ClienteValidador.isValido(cliente));
  }
  
  @Test
  public void fafalhaAoValidarClienteComTelefoneInvalido() {
    cliente.setTelefone("ab900000000");
    assertFalse(ClienteValidador.isValido(cliente));
  }
}
package com.dio.desafioprojeto.padroes.service;

import com.dio.desafioprojeto.padroes.model.Cliente;

public interface ClienteServiceStrategy {

  Iterable<Cliente> buscaTodos();

  Cliente buscaPorId(Long id);

  void salva(Cliente cliente);

  void atualiza(Long id, Cliente cliente);

  void deleta(Long id);
}
package com.dio.desafioprojeto.padroes.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dio.desafioprojeto.padroes.model.Cliente;
import com.dio.desafioprojeto.padroes.service.ClienteServiceStrategy;

@RestController
@RequestMapping("cliente")
public class ClienteRestController {

  @Autowired
  private ClienteServiceStrategy clienteServiceStrategy;

  @GetMapping
  public ResponseEntity<Iterable<Cliente>> buscaTodos() {
    return ResponseEntity.ok(clienteServiceStrategy.buscaTodos());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> buscaPorId(@PathVariable Long id) {
    try {
      return ResponseEntity.ok(clienteServiceStrategy.buscaPorId(id));
    } catch (NoSuchElementException e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "O cliente [id=" + id + " não existe.");
    }
  }

  @PostMapping
  public ResponseEntity<Void> salva(@RequestBody Cliente cliente) {
    try {
      clienteServiceStrategy.salva(cliente);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Falha ao salvar cliente. O cliente informado possui um ou mais dados inválidos.");
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> atualiza(@PathVariable Long id, @RequestBody Cliente cliente) {
    try {
      clienteServiceStrategy.atualiza(id, cliente);
      return ResponseEntity.ok().build();
    } catch (NoSuchElementException e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "O cliente [id=" + id + " não existe.");
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "O cliente informado possui um ou mais dados inválidos.");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleta(@PathVariable Long id) {
    try {
      clienteServiceStrategy.deleta(id);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
          "Falha ao deletar: O valor do id é null.");
    }
  }
}
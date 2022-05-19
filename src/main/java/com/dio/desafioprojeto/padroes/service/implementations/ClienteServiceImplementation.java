package com.dio.desafioprojeto.padroes.service.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.desafioprojeto.padroes.model.Avaliacao;
import com.dio.desafioprojeto.padroes.model.AvaliacaoRepository;
import com.dio.desafioprojeto.padroes.model.Cliente;
import com.dio.desafioprojeto.padroes.model.ClienteRepository;
import com.dio.desafioprojeto.padroes.model.Endereco;
import com.dio.desafioprojeto.padroes.model.EnderecoRepository;
import com.dio.desafioprojeto.padroes.service.ClienteServiceStrategy;
import com.dio.desafioprojeto.padroes.service.ViaCepService;
import com.dio.desafioprojeto.padroes.service.business.Validador;

@Service
public class ClienteServiceImplementation implements ClienteServiceStrategy {

  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private EnderecoRepository enderecoRepository;
  @Autowired
  private AvaliacaoRepository avaliacaoRepository;
  @Autowired
  private ViaCepService viaCepService;

  @Override
  public void salva(Cliente cliente) {
    if (Validador.isValido(cliente)) {
      adicionaEndereco(cliente);
      adicionaAvaliacoes(cliente);
      clienteRepository.save(cliente);
    } else {
      throw new IllegalArgumentException("O cliente informado possui um ou mais dados inválidos.");
    }
  }

  private void adicionaEndereco(Cliente cliente) {
    Long id = cliente.getEndereco().getId();
    Endereco endereco = enderecoRepository.findById(id).orElseGet(() -> {
      Endereco novoEndereco = viaCepService.consultaCep(cliente.getEndereco().getCep());
      enderecoRepository.save(novoEndereco);
      return novoEndereco;
    });
    cliente.setEndereco(endereco);
  }

  private void adicionaAvaliacoes(Cliente cliente) {
    List<Avaliacao> avaliacoes = cliente.getAvaliacoes();
    avaliacaoRepository.saveAll(avaliacoes);
    cliente.setAvaliacoes(avaliacoes);
  }

  @Override
  public Cliente buscaPorId(Long id) {
    return clienteRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Cliente [id=" + id + "] não encontrado."));
  }

  @Override
  public Iterable<Cliente> buscaTodos() {
    return clienteRepository.findAll();
  }

  @Override
  public void atualiza(Long id, Cliente cliente) {
    Optional<Cliente> c = clienteRepository.findById(id);
    if (c.isPresent())
      salva(cliente);
    else
      throw new NoSuchElementException("Cliente [id=" + id + "] não encontrado.");
  }

  @Override
  public void deleta(Long id) throws IllegalArgumentException {
    clienteRepository.deleteById(id);
  }
}
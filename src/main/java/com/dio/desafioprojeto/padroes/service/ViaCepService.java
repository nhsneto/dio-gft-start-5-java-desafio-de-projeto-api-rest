package com.dio.desafioprojeto.padroes.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dio.desafioprojeto.padroes.model.Endereco;

/**
 * Cliente HTTP, implementado através do Spring Cloud OpenFeign, que consome a API do
 * <a href="https://viacep.com.br/">ViaCEP</a> 
 * 
 * @author Nelson Henrique
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

  @GetMapping("/{cep}/json/")
  Endereco consultaCep(@PathVariable("cep") String cep);
}
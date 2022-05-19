package com.dio.desafioprojeto.padroes.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Long> {

}
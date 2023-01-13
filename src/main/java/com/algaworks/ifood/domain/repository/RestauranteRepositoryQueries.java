package com.algaworks.ifood.domain.repository;

import com.algaworks.ifood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepositoryQueries {

    // T11, T12 e T13 - é preciso adicionar esta interface à RestauranteRepository, junto com JpaRepository
    List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
}

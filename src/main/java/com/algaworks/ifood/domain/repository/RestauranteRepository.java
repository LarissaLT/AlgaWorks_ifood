package com.algaworks.ifood.domain.repository;

import com.algaworks.ifood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> queryPorPrecoByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

//    List<Restaurante> queryPorNomeByNomeContaining(String nome);

//    @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
    List<Restaurante> consultarPorNomeEId(String nome, @Param("id") Long cozinha);
}

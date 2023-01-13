package com.algaworks.ifood.domain.repository;

import com.algaworks.ifood.domain.model.Cozinha;
import com.algaworks.ifood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>,
        RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
    // T07 - utiliza keyword between para filtrar valores entre

    List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
    // T08 - mais de 1 filtro por nome e por id.

     @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
     List<Restaurante> consultarPorNomeEId(String nome, @Param("id") Long cozinha);
    //  T09 - utilizar @Query para personalizar nome do método
    //@Param é um tipo especial de comentário, é usado para denotar uma descrição
    // do parâmetro que um método pode receber. Poderia ter usado cozinha no lugar de :id

    List<Restaurante> consultarPorNomeEIdCozinha(String nome, @Param("id") Long cozinha);
    // T10 - está funcionando a partir do META-INF. Coloca as inf do @Query no file orm.xml
}

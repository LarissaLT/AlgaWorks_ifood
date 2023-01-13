package com.algaworks.ifood.domain.repository;

import com.algaworks.ifood.domain.model.Cozinha;
import com.algaworks.ifood.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> nome(String nome); // T01 - utilizando o nome do atributo "nome"

    List<Cozinha> findByNome(String nome); // T02 - find + By + nome do atributo

    List<Cozinha> findQualquerCoisaByNome(String nome); // T03 - pode escrever qualquer coisa depois do find

    List<Cozinha> findTodasByNomeContaining(String nome); // T04 - Containing serve como like % %

    Optional<Cozinha> findFirstRestauranteByNomeContaining(String nome);
    // T05 - 1º selecionado(apenas 1)
    // Se quiser buscar mais, utilizar no lugar de first Top2/Top3/Top10

    boolean existsByNome(String nome);
    // T06 - verificar se existe. True ou false
    // pode usar - int countByNome(String nome) - para saber quantos existem com aquele nome


    /*
    Exemplos de Keywords:
    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
     */

    // são equivalentes find, get, query e stream


}


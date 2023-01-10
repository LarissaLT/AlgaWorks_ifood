package com.algaworks.ifood.domain.repository;

import com.algaworks.ifood.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository {

    List<Cozinha> listar();
    List<Cozinha> consultarPorNome(String nome);
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Long id);


}


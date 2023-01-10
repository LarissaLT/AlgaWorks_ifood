package com.algaworks.ifood.domain.repository;

import com.algaworks.ifood.domain.model.Cidade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository {

    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Long id);

}

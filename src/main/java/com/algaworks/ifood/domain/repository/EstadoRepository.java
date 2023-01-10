package com.algaworks.ifood.domain.repository;

import com.algaworks.ifood.domain.model.Estado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository {

    List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estados);
    void remover(Long id);


}

package com.algaworks.ifood.domain.repository;

import com.algaworks.ifood.domain.model.Cozinha;
import com.algaworks.ifood.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante restaurante);
    void remover(Long id);

}

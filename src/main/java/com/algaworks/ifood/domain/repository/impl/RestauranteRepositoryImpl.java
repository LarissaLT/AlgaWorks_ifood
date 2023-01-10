package com.algaworks.ifood.domain.repository.impl;

import com.algaworks.ifood.domain.model.Cidade;
import com.algaworks.ifood.domain.model.Restaurante;
import com.algaworks.ifood.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> listar() {
        return manager.createQuery("from Restaurante", Restaurante.class)
                .getResultList();
    }

    @Override
    public Restaurante buscar(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Restaurante restaurante = buscar(id);

        if (restaurante == null) {
            throw new EmptyResultDataAccessException(1);
        }

        manager.remove(restaurante);
    }

}
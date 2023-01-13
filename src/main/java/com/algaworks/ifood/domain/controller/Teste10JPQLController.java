package com.algaworks.ifood.domain.controller;

import com.algaworks.ifood.domain.model.Restaurante;
import com.algaworks.ifood.domain.repository.CozinhaRepository;
import com.algaworks.ifood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste-10")
public class Teste10JPQLController {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/restaurantes/por-nome-id")
    public List<Restaurante> consultarRestaurantePorNomeEIddaCozinha(String nome, Long cozinhaId) {
        return restauranteRepository.consultarPorNomeEIdCozinha(nome, cozinhaId);
    }
}

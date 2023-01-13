package com.algaworks.ifood.domain.controller;

import com.algaworks.ifood.domain.model.Cozinha;
import com.algaworks.ifood.domain.model.Restaurante;
import com.algaworks.ifood.domain.repository.CozinhaRepository;
import com.algaworks.ifood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/teste-01")
public class Teste01QueryMethodsController {

    @Autowired
    private CozinhaRepository cozinhaRepository;
    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/restaurantes/por-nome-id")
    public List<Restaurante> consultarCozinhaPorNomeEId(String nome,@RequestParam("maritaca") Long cozinhaId) {
        return restauranteRepository.consultarPorNomeEId(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/por-preco")
    public List<Restaurante> consultaRestauranterPorPreco(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial,taxaFinal);
    }
}

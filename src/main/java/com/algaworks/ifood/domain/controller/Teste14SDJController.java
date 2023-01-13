package com.algaworks.ifood.domain.controller;

import com.algaworks.ifood.domain.model.Restaurante;
import com.algaworks.ifood.domain.repository.RestauranteRepository;
import com.algaworks.ifood.infrastructure.repository.spec.RestauranteComFreteGratisSpec;
import com.algaworks.ifood.infrastructure.repository.spec.RestauranteComNomeSemelhanteSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste-14")
public class Teste14SDJController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/restaurantes/frete-gratis")
    public List<Restaurante> restaurantesComFreteGratis(String nome){
        RestauranteComFreteGratisSpec comFreteGratis = new RestauranteComFreteGratisSpec();
        RestauranteComNomeSemelhanteSpec comNomeSemelhante = new RestauranteComNomeSemelhanteSpec(nome);

        return restauranteRepository.findAll(comFreteGratis.and(comNomeSemelhante));
    }
}

package com.algaworks.ifood.domain.controller;

import com.algaworks.ifood.domain.model.Cozinha;
import com.algaworks.ifood.domain.repository.CozinhaRepository;
import com.algaworks.ifood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/teste-06")
public class Teste06QueryMethodsController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping("/cozinhas/existe-nome")
    public boolean cozinhaExisteNome(@RequestParam ("nome") String nome) {
        return cozinhaRepository.existsByNome(nome);
    }
    }

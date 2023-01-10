package com.algaworks.ifood;

import com.algaworks.ifood.model.Cliente;
import com.algaworks.ifood.service.AtivacaoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeliveryController {
    private AtivacaoClienteService ativacaoClienteService;

    public DeliveryController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888");

        ativacaoClienteService.ativar(joao);

        return "Hello!";
    }
}

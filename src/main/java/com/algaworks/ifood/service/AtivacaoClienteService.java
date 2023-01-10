package com.algaworks.ifood.service;

import com.algaworks.ifood.model.Cliente;
import com.algaworks.ifood.notificacao.NivelUrgencia;
import com.algaworks.ifood.notificacao.Notificador;
import com.algaworks.ifood.notificacao.TipoDoNotificador;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    //@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    //private Notificador notificador; (NotificadorService)

    /*@PostConstruct
    public void init(){
        System.out.println("INIT");
    }

    //@PreDestroy
    public void destroy(){
        System.out.println("DESTROY");
    }
     */

    public void ativar(Cliente cliente) {
        cliente.ativar();

        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
        //notificador.notificar(cliente, "Seu cadastro no sistema está ativo!"); (NotificadorService)
    }
}

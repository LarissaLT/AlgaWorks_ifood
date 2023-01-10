package com.algaworks.ifood.listener;

import com.algaworks.ifood.notificacao.NivelUrgencia;
import com.algaworks.ifood.notificacao.Notificador;
import com.algaworks.ifood.notificacao.TipoDoNotificador;
import com.algaworks.ifood.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
    }
}

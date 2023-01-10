package com.algaworks.ifood.notificacao;

import com.algaworks.ifood.model.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}

package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.model.Cliente;

public interface NotificadorClient {
    void notificar(Cliente cliente, String s);
}

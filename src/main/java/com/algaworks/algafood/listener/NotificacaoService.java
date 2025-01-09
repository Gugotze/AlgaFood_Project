package com.algaworks.algafood.listener;

import com.algaworks.algafood.annotations.NivelUrgencia;
import com.algaworks.algafood.annotations.TipoDoNotificador;
import com.algaworks.algafood.event.ClienteAtivadoEvent;
import com.algaworks.algafood.notificacao.NotificadorClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class NotificacaoService {

    @Autowired
    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    private NotificadorClient client;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
    client.notificar(event.getCliente(), "Seu cadastro esta ativado no sistema pelo event listener");
    }

}



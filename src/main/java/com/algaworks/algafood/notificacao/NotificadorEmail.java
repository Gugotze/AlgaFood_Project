package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.annotations.NivelUrgencia;
import com.algaworks.algafood.annotations.TipoDoNotificador;
import com.algaworks.algafood.model.Cliente;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.ValidHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
public class NotificadorEmail implements NotificadorClient {

    @Autowired
    private NotificadorProperties properties;


    public NotificadorEmail(){
        log.info("Notificador email Prod");
    }

    public void notificar(Cliente cliente, String mensagem) {
        log.info("Host: {}", properties.getHostServidor());
        log.info("Port: {}", properties.getPortaServidor());

        System.out.printf("Notificando %s atraves do email %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
    }
}

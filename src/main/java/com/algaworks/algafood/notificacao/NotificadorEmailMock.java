package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.annotations.NivelUrgencia;
import com.algaworks.algafood.annotations.TipoDoNotificador;
import com.algaworks.algafood.model.Cliente;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@TipoDoNotificador(NivelUrgencia.DEV_URGENCIA)
public class NotificadorEmailMock implements NotificadorClient {

    public NotificadorEmailMock(){
        log.info("Notificador email Dev");
    }

    public void notificar(Cliente cliente, String mensagem) {

        System.out.printf("Notificando %s atraves do email %s: %s\n", cliente.getNome(), cliente.getEmail(), mensagem);
    }
}

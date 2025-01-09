package com.algaworks.algafood.notificacao;

import com.algaworks.algafood.annotations.NivelUrgencia;
import com.algaworks.algafood.annotations.TipoDoNotificador;
import com.algaworks.algafood.model.Cliente;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@TipoDoNotificador(NivelUrgencia.URGENTE)
public class NotificadorSMS implements NotificadorClient {

    public void notificar(Cliente cliente, String mensagem) {

        System.out.printf("Notificando %s por SMS através do telefone %s: %s\n", cliente.getNome(), cliente.getTelefone(), mensagem);
    }
}

package com.algaworks.algafood.listener;

import com.algaworks.algafood.event.ClienteAtivadoEvent;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class EmissaoNotaFiscalService {

    @EventListener
    public void clienteAtivadoListener (ClienteAtivadoEvent event){
        log.info("Emitindo nota fiscal para cliente {}", event.getCliente().getNome());

    }
}

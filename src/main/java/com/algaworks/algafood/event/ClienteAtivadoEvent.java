package com.algaworks.algafood.event;

import com.algaworks.algafood.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteAtivadoEvent {

    private Cliente cliente;
}

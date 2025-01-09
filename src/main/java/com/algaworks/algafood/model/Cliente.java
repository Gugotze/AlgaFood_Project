package com.algaworks.algafood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Cliente {

    private String nome;
    private String email;
    private String telefone;
    private boolean ativo = false;

    public Cliente(String name, String mail, String telefone) {
        this.nome= name;
        this.email=mail;
        this.telefone=telefone;
    }

    public void ativar(){
        this.ativo = true;
    }

}

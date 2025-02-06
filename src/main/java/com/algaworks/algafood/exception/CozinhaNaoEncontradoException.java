package com.algaworks.algafood.exception;

public class CozinhaNaoEncontradoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public CozinhaNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public CozinhaNaoEncontradoException(Long cozinhaId){
        this(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
    }

}

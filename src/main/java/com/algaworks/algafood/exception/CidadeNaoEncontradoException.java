package com.algaworks.algafood.exception;

public class CidadeNaoEncontradoException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public CidadeNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    public CidadeNaoEncontradoException(Long cidadeId){
        this(String.format("Não existe um cadastro de cidade com código %d", cidadeId));
    }

}

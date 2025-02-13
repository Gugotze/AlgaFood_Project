package com.algaworks.algafood.exceptionHandler;


import lombok.Getter;

@Getter
public enum ProblemType {

    MENSAGEM_INCOMPREENSIVEL("Mensagem incompreensível", "mensagem-incompreensivel"),
    ENTIDADE_NAO_ENCONTRADA("Entidade não encontrada", "entidade-nao-encontrada"),
    ENTIDADE_EM_USO("Entidade em uso", "entidade-em-uso"),
    ERRO_NEGOCIO("Violação de regra de negócio", "erro-negocio"),
    PARAMETRO_INVALIDO("Parâmetro inválido", "parametro-invalido"),
    RECURSO_NAO_ENCONTRADO("Recurso não encontrado", "recurso-nao-encontrado"),
    ERRO_DE_SISTEMA("Erro de sistema", "erro-de-sistema");

    private String title;
    private String uri;

    ProblemType(String title, String uri) {
        this.title = title;
        this.uri = "https://algafood.com.br/" + uri;
    }

}

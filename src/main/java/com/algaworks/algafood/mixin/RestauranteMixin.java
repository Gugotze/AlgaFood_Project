package com.algaworks.algafood.mixin;

import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.domain.Endereco;
import com.algaworks.algafood.domain.FormaPagamento;
import com.algaworks.algafood.domain.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class RestauranteMixin {
    @JsonIgnoreProperties(value = "nome", allowGetters = true)
    private Cozinha cozinha;

    @JsonIgnore
    private Endereco endereco;

  //  @JsonIgnore
    private OffsetDateTime dataCadastro;

 //   @JsonIgnore
    private OffsetDateTime dataAtualizacao;

    @JsonIgnore
    private List<FormaPagamento> formasPagamento = new ArrayList<>();

    @JsonIgnore
    private List<Produto> produtos = new ArrayList<>();
}

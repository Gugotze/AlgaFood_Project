package com.algaworks.algafood.mixin;

import com.algaworks.algafood.domain.Restaurante;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class CozinhaMixin {

    @JsonIgnore
    private List<Restaurante> restaurantes;
}

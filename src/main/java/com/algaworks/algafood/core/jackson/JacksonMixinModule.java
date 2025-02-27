package com.algaworks.algafood.core.jackson;

import com.algaworks.algafood.domain.Cidade;
import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.mixin.CidadeMixin;
import com.algaworks.algafood.mixin.CozinhaMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public JacksonMixinModule() {
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }
}

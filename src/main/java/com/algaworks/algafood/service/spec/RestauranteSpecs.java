package com.algaworks.algafood.service.spec;

import com.algaworks.algafood.domain.Restaurante;
import org.springframework.data.jpa.domain.Specification;

public class RestauranteSpecs {

    public static Specification<Restaurante> comFreteGratis(){
        return (root, query, builder) -> builder.equal(root.get("taxaFrete"), 0);
    }

    public static Specification<Restaurante> comNomeSemelhante(String nome){
        return (root, query, builder) -> builder.like(root.get("nome"), "%" + nome + "%");
    }
}

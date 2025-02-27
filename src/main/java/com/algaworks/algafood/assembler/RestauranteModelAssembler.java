package com.algaworks.algafood.assembler;

import com.algaworks.algafood.domain.Restaurante;
import com.algaworks.algafood.dto.CozinhaDTO;
import com.algaworks.algafood.dto.RestauranteDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestauranteModelAssembler {

    public  RestauranteDTO toModel(Restaurante restaurante) {
        RestauranteDTO restauranteModel = new RestauranteDTO();
        restauranteModel.setId(restaurante.getId());
        restauranteModel.setNome(restaurante.getNome());
        restauranteModel.setTaxaFrete(restaurante.getTaxaFrete());
        restauranteModel.setCozinha(new CozinhaDTO());
        restauranteModel.getCozinha().setId(restaurante.getCozinha().getId());
        restauranteModel.getCozinha().setNome(restaurante.getCozinha().getNome());
        return restauranteModel;
    }

    public List<RestauranteDTO> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream()
                .map(restaurante -> toModel(restaurante))
                .collect(Collectors.toList());
    }
}

package com.algaworks.algafood.assembler;

import com.algaworks.algafood.domain.Restaurante;
import com.algaworks.algafood.dto.CozinhaDTO;
import com.algaworks.algafood.dto.RestauranteDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RestauranteModelAssembler {

    private final ModelMapper modelMapper;

    public  RestauranteDTO toModel(Restaurante restaurante) {
        return modelMapper.map(restaurante, RestauranteDTO.class);
    }

    public List<RestauranteDTO> toCollectionModel(List<Restaurante> restaurantes) {
        return restaurantes.stream()
                .map(restaurante -> toModel(restaurante))
                .collect(Collectors.toList());
    }
}

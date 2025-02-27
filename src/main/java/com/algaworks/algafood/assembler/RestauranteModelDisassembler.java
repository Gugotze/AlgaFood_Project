package com.algaworks.algafood.assembler;

import com.algaworks.algafood.domain.Restaurante;
import com.algaworks.algafood.input.RestauranteInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestauranteModelDisassembler {

    private final ModelMapper modelMapper;

    public Restaurante toDomainObject(RestauranteInput restauranteInput) {
        return modelMapper.map(restauranteInput, Restaurante.class);
    }
}

package com.algaworks.algafood.service;

import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.domain.Restaurante;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    private static final String MSG_RESTAURANTE_NAO_ENCONTRADO
            = "Não existe um cadastro de restaurante com código %d";

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

//		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
//			.orElseThrow(() -> new EntidadeNaoEncontradaException(
//					String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    public Restaurante buscarOuFalhar(Long restauranteId) {
        return restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId)));
    }

}
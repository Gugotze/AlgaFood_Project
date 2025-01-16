package com.algaworks.algafood.service;

import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.domain.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.Restaurante;
import com.algaworks.algafood.repository.CozinhaRepository;
import com.algaworks.algafood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public List<Restaurante> listar (){
        return restauranteRepository.listar();
    }

    public Restaurante buscar(Long id){
        return restauranteRepository.buscar(id);
    }

    public Restaurante salvar(Restaurante restaurante){
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

        if (cozinha == null){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
        }
        restaurante.setCozinha(cozinha);
        return restauranteRepository.salvar(restaurante);
    }

}

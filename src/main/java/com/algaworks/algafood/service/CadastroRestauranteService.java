package com.algaworks.algafood.service;

import com.algaworks.algafood.domain.Restaurante;
import com.algaworks.algafood.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> listar (){
        return restauranteRepository.listar();
    }

    public Restaurante buscar(Long id){
        return restauranteRepository.buscar(id);
    }

}

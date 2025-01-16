package com.algaworks.algafood.repository;

import com.algaworks.algafood.domain.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository {


    List<Restaurante> listar();

    Restaurante buscar(Long id);

    Restaurante salvar(Restaurante restaurante);

    Restaurante atualizar(Restaurante restaurante);

    void remover(Restaurante restaurante);

}

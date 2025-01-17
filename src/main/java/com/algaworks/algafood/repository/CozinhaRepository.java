package com.algaworks.algafood.repository;


import com.algaworks.algafood.domain.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    // List <Cozinha> consultarPorNome(String nome);

}

package com.algaworks.algafood.controller;

import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    CozinhaRepository cozinhaRepository;

//  @GetMapping("/cozinhas/por-nome")
//  public List<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome) {

//      return cozinhaRepository.consultarPorNome(nome);
//  }

}

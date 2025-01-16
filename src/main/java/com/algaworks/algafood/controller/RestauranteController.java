package com.algaworks.algafood.controller;

import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.domain.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.Restaurante;
import com.algaworks.algafood.repository.RestauranteRepository;
import com.algaworks.algafood.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return cadastroRestauranteService.listar();
    }

    @GetMapping("/{id}")
    public Restaurante buscar(@PathVariable Long id) {
        return cadastroRestauranteService.buscar(id);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante) {

        try {
            restaurante = cadastroRestauranteService.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody Restaurante restaurante) {


        try {
            Restaurante restauranteAtual = cadastroRestauranteService.buscar(id);

            if (restauranteAtual != null) {
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

                restauranteAtual = cadastroRestauranteService.salvar(restauranteAtual);
                return ResponseEntity.ok(restauranteAtual);
            }

            return ResponseEntity.notFound().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

package com.algaworks.algafood.controller;

import com.algaworks.algafood.assembler.CozinhaInputAssembler;
import com.algaworks.algafood.assembler.CozinhaInputDisassembler;
import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.dto.CozinhaDTO;
import com.algaworks.algafood.input.CozinhaInput;
import com.algaworks.algafood.repository.CozinhaRepository;
import com.algaworks.algafood.service.CadastroCozinhaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    private final CozinhaRepository cozinhaRepository;

    private final CadastroCozinhaService cadastroCozinha;

    private final CozinhaInputDisassembler cozinhaInputDisassembler;

    private final CozinhaInputAssembler cozinhaInputAssembler;

    @GetMapping
    public List<CozinhaDTO> listar() {
        List<Cozinha> todasCozinhas = cozinhaRepository.findAll();

        return cozinhaInputAssembler.toCollectionModel(todasCozinhas);
    }

    @GetMapping("/{cozinhaId}")
    public CozinhaDTO buscar(@PathVariable Long cozinhaId) {
        Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

        return cozinhaInputAssembler.toModel(cozinha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CozinhaDTO adicionar(@RequestBody @Valid CozinhaInput cozinhaInput) {
        Cozinha cozinha = cozinhaInputDisassembler.toDomainObject(cozinhaInput);
        cozinha = cadastroCozinha.salvar(cozinha);

        return cozinhaInputAssembler.toModel(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public CozinhaDTO atualizar(@PathVariable Long cozinhaId,
                                  @RequestBody @Valid CozinhaInput cozinhaInput) {
        Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
        cozinhaInputDisassembler.copyToDomainObject(cozinhaInput, cozinhaAtual);
        cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);

        return cozinhaInputAssembler.toModel(cozinhaAtual);
    }

    @DeleteMapping("/{cozinhaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cozinhaId) {
        cadastroCozinha.excluir(cozinhaId);
    }

}

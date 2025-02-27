package com.algaworks.algafood.controller;

import com.algaworks.algafood.assembler.EstadoInputAssembler;
import com.algaworks.algafood.assembler.EstadoInputDisassembler;
import com.algaworks.algafood.domain.Estado;
import com.algaworks.algafood.dto.EstadoDTO;
import com.algaworks.algafood.input.EstadoInput;
import com.algaworks.algafood.repository.EstadoRepository;
import com.algaworks.algafood.service.CadastroEstadoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
@AllArgsConstructor
public class EstadoController {

    private final EstadoRepository estadoRepository;

    private final CadastroEstadoService cadastroEstado;

    private final EstadoInputAssembler estadoInputAssembler;

    private final EstadoInputDisassembler estadoInputDisassembler;

    @GetMapping
    public List<EstadoDTO> listar() {
        List<Estado> todosEstados = estadoRepository.findAll();

        return estadoInputAssembler.toCollectionModel(todosEstados);
    }

    @GetMapping("/{estadoId}")
    public EstadoDTO buscar(@PathVariable Long estadoId) {
        Estado estado = cadastroEstado.buscarOuFalhar(estadoId);

        return estadoInputAssembler.toModel(estado);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstadoDTO adicionar(@RequestBody @Valid EstadoInput estadoInput) {
        Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);

        estado = cadastroEstado.salvar(estado);

        return estadoInputAssembler.toModel(estado);
    }

    @PutMapping("/{estadoId}")
    public EstadoDTO atualizar(@PathVariable Long estadoId,
                                 @RequestBody @Valid EstadoInput estadoInput) {
        Estado estadoAtual = cadastroEstado.buscarOuFalhar(estadoId);

        estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);

        estadoAtual = cadastroEstado.salvar(estadoAtual);

        return estadoInputAssembler.toModel(estadoAtual);
    }

    @DeleteMapping("/{estadoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long estadoId) {
        cadastroEstado.excluir(estadoId);
    }

}
package com.algaworks.algafood.service;

import com.algaworks.algafood.domain.Cidade;
import com.algaworks.algafood.domain.Estado;
import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.repository.CidadeRepository;
import com.algaworks.algafood.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    public static final String NÃO_EXISTE_UM_CADASTRO_DE_CIDADE_COM_CÓDIGO_D = "Não existe um cadastro de cidade com código %d";
    public static final String CIDADE_DE_CÓDIGO_D_NÃO_PODE_SER_REMOVIDA_POIS_ESTÁ_EM_USO = "Cidade de código %d não pode ser removida, pois está em uso";
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();

        Estado estado = estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de estado com código %d", estadoId)));

        cidade.setEstado(estado);

        return cidadeRepository.save(cidade);
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format(NÃO_EXISTE_UM_CADASTRO_DE_CIDADE_COM_CÓDIGO_D, cidadeId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(CIDADE_DE_CÓDIGO_D_NÃO_PODE_SER_REMOVIDA_POIS_ESTÁ_EM_USO, cidadeId));
        }
    }

    public Cidade buscarOuFalhar(Long cidadeId) {
        return cidadeRepository.findById(cidadeId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(NÃO_EXISTE_UM_CADASTRO_DE_CIDADE_COM_CÓDIGO_D, cidadeId)));
    }

}
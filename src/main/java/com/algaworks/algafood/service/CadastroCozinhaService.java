package com.algaworks.algafood.service;

import com.algaworks.algafood.domain.Cozinha;
import com.algaworks.algafood.exception.CozinhaNaoEncontradoException;
import com.algaworks.algafood.exception.EntidadeEmUsoException;
import com.algaworks.algafood.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCozinhaService {

    private static final String MSG_COZINHA_EM_USO
            = "Cozinha de código %d não pode ser removida, pois está em uso";

    private static final String MSG_COZINHA_NAO_ENCONTRADA
            = "Não existe um cadastro de cozinha com código %d";

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    @Transactional
    public void excluir(Long cozinhaId) {
        try {
            buscarOuFalhar(cozinhaId);
            cozinhaRepository.deleteById(cozinhaId);
            cozinhaRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new CozinhaNaoEncontradoException(cozinhaId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_COZINHA_EM_USO, cozinhaId));
        }
    }

    public Cozinha buscarOuFalhar(Long cozinhaId) {
        return cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new CozinhaNaoEncontradoException(cozinhaId));
    }

}
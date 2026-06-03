package com.fiap.ec.missaoespecial.service;

import com.fiap.ec.missaoespecial.model.Alerta;
import com.fiap.ec.missaoespecial.model.AnotacaoMissao;
import com.fiap.ec.missaoespecial.repository.AlertaRepository;
import com.fiap.ec.missaoespecial.repository.AnotacaoMissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotacaoMissaoService {
    private final AnotacaoMissaoRepository repository;

    public AnotacaoMissaoService(AnotacaoMissaoRepository repository) {
        this.repository = repository;
    }

    public AnotacaoMissao salvar(AnotacaoMissao anotacao) {
        return repository.save(anotacao);
    }

    public List<AnotacaoMissao> listar() {
        return repository.findAll();
    }
}

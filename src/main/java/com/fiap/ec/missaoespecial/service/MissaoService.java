package com.fiap.ec.missaoespecial.service;

import com.fiap.ec.missaoespecial.model.Especialidade;
import com.fiap.ec.missaoespecial.model.Missao;
import com.fiap.ec.missaoespecial.repository.EspecialidadeRepository;
import com.fiap.ec.missaoespecial.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {
    private final MissaoRepository repository;

    public MissaoService(MissaoRepository repository) {
        this.repository = repository;
    }

    public Missao salvar(Missao missao) {
        return repository.save(missao);
    }

    public List<Missao> listar() {
        return repository.findAll();
    }

    public Missao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Missao não encontrada"));
    }

    public Missao atualizar(Long id, Missao missaoAtualizado) {
        Missao missaoExistente = buscarPorId(id);
        missaoExistente.setNome(missaoAtualizado.getNome());
        missaoExistente.setDescricao(missaoAtualizado.getDescricao());
        missaoExistente.setStatus(missaoAtualizado.setStatus());
        missaoExistente.setModulos(missaoAtualizado.getModulos());
        missaoExistente.setSensores(missaoAtualizado.getSensores());

        return repository.save(missaoExistente);
    }

    public void deletar(Long id) {
        Missao missao = buscarPorId(id);
        repository.delete(missao);
    }
}

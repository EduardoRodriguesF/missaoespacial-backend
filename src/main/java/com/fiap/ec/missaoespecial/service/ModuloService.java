package com.fiap.ec.missaoespecial.service;

import com.fiap.ec.missaoespecial.model.Modulo;
import com.fiap.ec.missaoespecial.repository.ModuloRepository;
import com.fiap.ec.missaoespecial.model.Missao;
import com.fiap.ec.missaoespecial.repository.MissaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloService {
    private final ModuloRepository repository;

    public ModuloService(ModuloRepository repository) {
        this.repository = repository;
    }

    public Modulo salvar(Modulo modulo) {
        return repository.save(modulo);
    }

    public List<Modulo> listar() {
        return repository.findAll();
    }

    public Modulo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modulo não encontrada"));
    }

    public Modulo atualizar(Long id, Modulo moduloAtualizado) {
        Modulo moduloExistente = buscarPorId(id);
        moduloExistente.setNome(moduloAtualizado.getNome());
        moduloExistente.setDescricao(moduloAtualizado.getDescricao());

        return repository.save(moduloExistente);
    }

    public void deletar(Long id) {
        Modulo modulo = buscarPorId(id);
        repository.delete(modulo);
    }
}

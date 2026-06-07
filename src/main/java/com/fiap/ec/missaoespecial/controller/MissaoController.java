package com.fiap.ec.missaoespecial.controller;

import com.fiap.ec.missaoespecial.model.AnotacaoMissao;
import com.fiap.ec.missaoespecial.model.Missao;
import com.fiap.ec.missaoespecial.service.AnotacaoMissaoService;
import com.fiap.ec.missaoespecial.service.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService missaoService;
    private final AnotacaoMissaoService anotacaoMissaoService;

    public MissaoController(MissaoService missaoService, AnotacaoMissaoService anotacaoService) {
        this.missaoService = missaoService;
        this.anotacaoMissaoService = anotacaoService;
    }

    @PostMapping
    public Missao salvar(@RequestBody Missao missao) {
        return missaoService.salvar(missao);
    }

    @GetMapping
    public List<Missao> listar() {
        return missaoService.listar();
    }

    @GetMapping("/{id}")
    public Missao buscarPorId(@PathVariable Long id) {
        return missaoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Missao atualizar(@PathVariable Long id, @RequestBody Missao missao) {
        return missaoService.atualizar(id, missao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        missaoService.deletar(id);
    }

    @PostMapping("/{id}/anotacoes")
    public AnotacaoMissao criarAnotacao(@PathVariable Long id, @RequestBody AnotacaoMissao anotacao) {
        Missao missao = missaoService.buscarPorId(id);
        anotacao.setMissao(missao);

        return anotacaoMissaoService.salvar(anotacao);
    }
}

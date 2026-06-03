package com.fiap.ec.missaoespecial.controller;

import com.fiap.ec.missaoespecial.model.Missao;
import com.fiap.ec.missaoespecial.service.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    private final MissaoService service;

    public MissaoController(MissaoService service) {
        this.service = service;
    }

    @PostMapping
    public Missao salvar(@RequestBody Missao missao) {
        return service.salvar(missao);
    }

    @GetMapping
    public List<Missao> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Missao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Missao atualizar(@PathVariable Long id, @RequestBody Missao missao) {
        return service.atualizar(id, missao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

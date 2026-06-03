package com.fiap.ec.missaoespecial.controller;

import com.fiap.ec.missaoespecial.model.Modulo;
import com.fiap.ec.missaoespecial.service.ModuloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modulos")
public class ModuloController {

    private final ModuloService service;

    public ModuloController(ModuloService service) {
        this.service = service;
    }

    @PostMapping
    public Modulo salvar(@RequestBody Modulo modulo) {
        return service.salvar(modulo);
    }

    @GetMapping
    public List<Modulo> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Modulo buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Modulo atualizar(@PathVariable Long id, @RequestBody Modulo modulo) {
        return service.atualizar(id, modulo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

package com.fiap.ec.missaoespecial.controller;

import com.fiap.ec.missaoespecial.model.Alerta;
import com.fiap.ec.missaoespecial.service.AlertaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/alertas")
public class AlertaController {

    private final AlertaService service;

    public AlertaController(AlertaService service) {
        this.service = service;
    }

    @PostMapping
    public Alerta salvar(@RequestBody Alerta alerta) {
        return service.salvar(alerta);
    }

    @GetMapping
    public List<Alerta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Alerta buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
}

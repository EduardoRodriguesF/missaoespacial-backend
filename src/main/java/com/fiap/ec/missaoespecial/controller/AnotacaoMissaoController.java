package com.fiap.ec.missaoespecial.controller;

import com.fiap.ec.missaoespecial.model.AnotacaoMissao;
import com.fiap.ec.missaoespecial.service.AnotacaoMissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/anotacoes")
public class AnotacaoMissaoController {

    private final AnotacaoMissaoService service;

    public AnotacaoMissaoController(AnotacaoMissaoService service) {
        this.service = service;
    }

    @PostMapping
    public AnotacaoMissao salvar(@RequestBody AnotacaoMissao anotacao) {
        return service.salvar(anotacao);
    }

    @GetMapping
    public List<AnotacaoMissao> listar() {
        return service.listar();
    }
}

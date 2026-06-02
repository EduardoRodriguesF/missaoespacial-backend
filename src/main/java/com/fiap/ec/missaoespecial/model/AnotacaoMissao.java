package com.fiap.ec.missaoespecial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "anotacoes_missao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnotacaoMissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private String status;

    @ManyToMany
    private List<Modulo> modulos;

    @ManyToMany
    private List<Sensor> sensores;
}

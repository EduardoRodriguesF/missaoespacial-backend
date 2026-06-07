package com.fiap.ec.missaoespecial.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
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

    @ManyToOne
    private Missao missao;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;
}

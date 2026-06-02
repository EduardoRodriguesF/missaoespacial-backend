package com.fiap.ec.missaoespecial.model;

import com.fiap.ec.missaoespecial.enums.SensorStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sensores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    private String descricao;

    @Column(nullable = false)
    private SensorStatus status;

    // Modulo sendo monitorado
    @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;
}

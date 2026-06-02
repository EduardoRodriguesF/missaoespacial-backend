package com.fiap.ec.missaoespecial.repository;

import com.fiap.ec.missaoespecial.model.Alerta;
import com.fiap.ec.missaoespecial.model.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}

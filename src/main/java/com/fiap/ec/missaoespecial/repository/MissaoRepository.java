package com.fiap.ec.missaoespecial.repository;

import com.fiap.ec.missaoespecial.model.Especialidade;
import com.fiap.ec.missaoespecial.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Long> {
}

package com.fiap.ec.missaoespecial.repository;

import com.fiap.ec.missaoespecial.model.AnotacaoMissao;
import com.fiap.ec.missaoespecial.model.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnotacaoMissaoRepository extends JpaRepository<AnotacaoMissao, Long> {
}

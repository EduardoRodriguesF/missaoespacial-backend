package com.fiap.ec.missaoespecial.repository;

import com.fiap.ec.missaoespecial.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}

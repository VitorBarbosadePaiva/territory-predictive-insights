package com.citizen.territory_predictive_insights.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citizen.territory_predictive_insights.dominio.Medicao;

@Repository
public interface MedicaoRepository extends JpaRepository<Medicao, Long> {
    List<Medicao> findBySensorId(String sensorId);
}
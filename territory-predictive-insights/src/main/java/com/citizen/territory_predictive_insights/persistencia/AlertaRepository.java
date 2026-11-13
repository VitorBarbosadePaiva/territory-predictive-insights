package com.citizen.territory_predictive_insights.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citizen.territory_predictive_insights.dominio.Alerta;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
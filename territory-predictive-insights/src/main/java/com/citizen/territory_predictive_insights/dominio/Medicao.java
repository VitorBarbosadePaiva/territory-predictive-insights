package com.citizen.territory_predictive_insights.dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicoes")
public class Medicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId;
    private String tipoSensor;
    private double valor;
    private LocalDateTime dataHora;

    public Medicao() {}

    public Medicao(String sensorId, String tipoSensor, double valor, LocalDateTime dataHora) {
        this.sensorId = sensorId;
        this.tipoSensor = tipoSensor;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Long getId() { return id; }
    public String getSensorId() { return sensorId; }
    public String getTipoSensor() { return tipoSensor; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
}
package com.citizen.territory_predictive_insights.dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alertas")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId;
    private double valorPrevisto;
    private double limiteEstourado;
    @Enumerated(EnumType.STRING)
    private NivelAlerta nivel;
    private String motivo;
    private LocalDateTime dataHora;

    public Alerta() {}

    public Alerta(String sensorId, double valorPrevisto, double limiteEstourado, NivelAlerta nivel, String motivo, LocalDateTime dataHora) {
        this.sensorId = sensorId;
        this.valorPrevisto = valorPrevisto;
        this.limiteEstourado = limiteEstourado;
        this.nivel = nivel;
        this.motivo = motivo;
        this.dataHora = dataHora;
    }

    public Long getId() { return id; }
    public String getSensorId() { return sensorId; }
    public double getValorPrevisto() { return valorPrevisto; }
    public double getLimiteEstourado() { return limiteEstourado; }
    public NivelAlerta getNivel() { return nivel; }
    public String getMotivo() { return motivo; }
    public LocalDateTime getDataHora() { return dataHora; }
}
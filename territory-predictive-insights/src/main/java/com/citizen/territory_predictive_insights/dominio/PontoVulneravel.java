package com.citizen.territory_predictive_insights.dominio;

public class PontoVulneravel extends ComponenteTerritorial {
    private double riscoAlagamento;

    public PontoVulneravel(String id, String nome, String regiao, String status, double riscoAlagamento) {
        super(id, nome, regiao, status);
        this.riscoAlagamento = riscoAlagamento;
    }

    @Override
    public void verificarStatus() {
        if (riscoAlagamento > 80.0) {
            setStatus("CRÍTICO");
        } else if (riscoAlagamento > 50.0) {
            setStatus("ALERTA");
        } else {
            setStatus("ESTÁVEL");
        }
    }

    public double getRiscoAlagamento() { return riscoAlagamento; }
    public void setRiscoAlagamento(double riscoAlagamento) { this.riscoAlagamento = riscoAlagamento; }
}
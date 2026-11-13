package com.citizen.territory_predictive_insights.servico;

public class ConfiguracaoSistema {
    private static ConfiguracaoSistema instancia;
    private double limiarCriticoChuva;

    private ConfiguracaoSistema() {
        this.limiarCriticoChuva = 80.0;
    }

    public static synchronized ConfiguracaoSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoSistema();
        }
        return instancia;
    }

    public double getLimiarCriticoChuva() { return limiarCriticoChuva; }
    public void setLimiarCriticoChuva(double limiarCriticoChuva) { this.limiarCriticoChuva = limiarCriticoChuva; }
}
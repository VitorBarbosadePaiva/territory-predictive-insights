package com.citizen.territory_predictive_insights.dominio;

import java.util.Random;

import com.citizen.territory_predictive_insights.excecao.DadosInvalidosException;

public class SensorPluviometro implements Sensor {
    private String id;
    private boolean funcionando = true;

    public SensorPluviometro(String id) {
        this.id = id;
    }

    @Override
    public double lerValor() throws DadosInvalidosException {
        if (!funcionando) {
            throw new DadosInvalidosException("Sensor Pluviômetro " + id + " está indisponível.");
        }
        double valor = new Random().nextDouble() * 120.0;
        if (valor < 0) {
            throw new DadosInvalidosException("Medição de chuva não pode ser negativa.");
        }
        return valor;
    }

    @Override
    public boolean verificarFuncionamento() {
        return funcionando;
    }

    @Override
    public String retornarTipo() {
        return "PLUVIOMETRO";
    }
}
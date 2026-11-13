package com.citizen.territory_predictive_insights.dominio;

import java.util.Random;

import com.citizen.territory_predictive_insights.excecao.DadosInvalidosException;

public class SensorNivelAgua implements Sensor {
    private String id;
    private boolean funcionando = true;

    public SensorNivelAgua(String id) { this.id = id; }

    @Override
    public double lerValor() throws DadosInvalidosException {
        if (!funcionando) throw new DadosInvalidosException("Sensor de Nível d'Água " + id + " indisponível.");
        double valor = new Random().nextDouble() * 5.0;
        if (valor < 0) throw new DadosInvalidosException("Nível d'água não pode ser negativo.");
        return valor;
    }

    @Override
    public boolean verificarFuncionamento() { return funcionando; }

    @Override
    public String retornarTipo() { return "NIVEL_AGUA"; }
}
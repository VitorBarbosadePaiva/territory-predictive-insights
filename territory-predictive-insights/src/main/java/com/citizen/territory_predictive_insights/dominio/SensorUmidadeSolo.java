package com.citizen.territory_predictive_insights.dominio;

import java.util.Random;

import com.citizen.territory_predictive_insights.excecao.DadosInvalidosException;

public class SensorUmidadeSolo implements Sensor {
    private String id;
    private boolean funcionando = true;

    public SensorUmidadeSolo(String id) { this.id = id; }

    @Override
    public double lerValor() throws DadosInvalidosException {
        if (!funcionando) throw new DadosInvalidosException("Sensor de Umidade " + id + " indisponível.");
        double valor = new Random().nextDouble() * 100.0;
        if (valor < 0 || valor > 100) throw new DadosInvalidosException("Umidade do solo fora da faixa permitida (0-100%).");
        return valor;
    }

    @Override
    public boolean verificarFuncionamento() { return funcionando; }

    @Override
    public String retornarTipo() { return "UMIDADE_SOLO"; }
}
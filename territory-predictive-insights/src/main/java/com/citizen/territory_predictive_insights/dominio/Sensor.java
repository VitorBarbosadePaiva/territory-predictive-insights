package com.citizen.territory_predictive_insights.dominio;

import com.citizen.territory_predictive_insights.excecao.DadosInvalidosException;

public interface Sensor {
    double lerValor() throws DadosInvalidosException;
    boolean verificarFuncionamento();
    String retornarTipo();
}
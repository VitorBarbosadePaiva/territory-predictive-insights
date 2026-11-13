package com.citizen.territory_predictive_insights.excecao;

public class DadosInvalidosException extends Exception {
    public DadosInvalidosException(String mensagem) {
        super(mensagem);
    }
}
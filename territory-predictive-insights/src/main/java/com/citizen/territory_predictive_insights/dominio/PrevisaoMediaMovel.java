package com.citizen.territory_predictive_insights.dominio;

import java.util.List;

public class PrevisaoMediaMovel extends EstrategiaPrevisao {
    @Override
    public double prever(List<Medicao> historico) {
        if (historico == null || historico.isEmpty()) return 0.0;
        double soma = 0;
        int limite = Math.min(historico.size(), 5);
        for (int i = 0; i < limite; i++) {
            soma += historico.get(historico.size() - 1 - i).getValor();
        }
        return soma / limite;
    }
}
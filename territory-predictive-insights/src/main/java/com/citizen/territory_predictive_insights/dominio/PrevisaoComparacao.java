package com.citizen.territory_predictive_insights.dominio;

import java.util.List;

public class PrevisaoComparacao extends EstrategiaPrevisao {
    @Override
    public double prever(List<Medicao> historico) {
        if (historico == null || historico.size() < 2) return 0.0;
        double ultima = historico.get(historico.size() - 1).getValor();
        double penultima = historico.get(historico.size() - 2).getValor();
        double variacao = ultima - penultima;
        return Math.max(0, ultima + (variacao * 1.5));
    }
}
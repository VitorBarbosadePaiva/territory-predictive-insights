package com.citizen.territory_predictive_insights.servico;

import com.citizen.territory_predictive_insights.dominio.EstrategiaPrevisao;
import com.citizen.territory_predictive_insights.dominio.PrevisaoComparacao;
import com.citizen.territory_predictive_insights.dominio.PrevisaoMediaMovel;

public class FabricaPrevisao {
    public static EstrategiaPrevisao criarEstrategia(String tipo) {
        if (tipo == null) return new PrevisaoMediaMovel();
        if (tipo.equalsIgnoreCase("COMPARACAO")) {
            return new PrevisaoComparacao();
        }
        return new PrevisaoMediaMovel();
    }
}
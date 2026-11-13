package com.citizen.territory_predictive_insights.dominio;

import java.util.List;

public abstract class EstrategiaPrevisao {
    public abstract double prever(List<Medicao> historico);
}
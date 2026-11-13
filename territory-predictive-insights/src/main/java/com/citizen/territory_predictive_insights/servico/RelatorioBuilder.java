package com.citizen.territory_predictive_insights.servico;

public class RelatorioBuilder {
    private StringBuilder sb = new StringBuilder();

    public RelatorioBuilder adicionarCabecalho(String titulo) {
        sb.append("=== ").append(titulo).append(" ===\n");
        return this;
    }

    public RelatorioBuilder adicionarSecao(String titulo, String conteudo) {
        sb.append("\n[").append(titulo).append("]\n").append(conteudo).append("\n");
        return this;
    }

    public String construir() {
        sb.append("\n===============================");
        return sb.toString();
    }
}
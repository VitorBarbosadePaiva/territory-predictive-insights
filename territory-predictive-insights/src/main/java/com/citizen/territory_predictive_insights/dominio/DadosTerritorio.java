package com.citizen.territory_predictive_insights.dominio;

import com.citizen.territory_predictive_insights.excecao.DadosInvalidosException;

public class DadosTerritorio {
    private String regiao;
    private int populacaoAfetada;
    private double limiarAlertaChuva;
    private final String codigoAcessoSeguro = "ADMIN2026";

    public DadosTerritorio(String regiao, int populacaoAfetada, double limiarAlertaChuva) {
        this.regiao = regiao;
        setPopulacaoAfetada(populacaoAfetada);
        setLimiarAlertaChuva(limiarAlertaChuva);
    }

    public void atualizarLimiares(String codigo, double novoLimiar) throws DadosInvalidosException {
        if (!codigoAcessoSeguro.equals(codigo)) {
            throw new DadosInvalidosException("Código de acesso inválido para alterar limiares.");
        }
        if (novoLimiar <= 0) {
            throw new DadosInvalidosException("O limiar deve ser maior que zero.");
        }
        this.limiarAlertaChuva = novoLimiar;
    }

    public void setPopulacaoAfetada(int populacao) {
        if (populacao < 0) throw new IllegalArgumentException("População não pode ser negativa.");
        this.populacaoAfetada = populacao;
    }

    public void setLimiarAlertaChuva(double limiar) {
        if (limiar < 0) throw new IllegalArgumentException("Limiar não pode ser negativo.");
        this.limiarAlertaChuva = limiar;
    }

    public String getRegiao() { return regiao; }
    public int getPopulacaoAfetada() { return populacaoAfetada; }
    public double getLimiarAlertaChuva() { return limiarAlertaChuva; }
}
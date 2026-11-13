package com.citizen.territory_predictive_insights.dominio;

public abstract class ComponenteTerritorial {
    private String id;
    private String nome;
    private String regiao;
    private String status;

    public ComponenteTerritorial(String id, String nome, String regiao, String status) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.status = status;
    }

    public abstract void verificarStatus();

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getRegiao() { return regiao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
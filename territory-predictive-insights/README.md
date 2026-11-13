# 🌍 Territory Predictive Insights (CitizenTech)
## Global Solution - 2º Semestre / 2026

* Turma: 2CCPY
* Disciplina: Programação Orientada a Objetos (POO)
* intituição: FIAP

## 👥 Integrantes do Grupo
* Arthur Traldi Felix — RM563477
* Vitor Barbosa de Paiva — RM565303

---

## 📋 Sobre o Projeto
O **Territory Predictive Insights** é uma solução desenvolvida em **Java com Spring Boot** voltada para o monitoramento de riscos climáticos locais, com foco em chuvas intensas e prevenção de alagamentos em áreas vulneráveis. O sistema simula leituras de sensores IoT (como pluviômetros, nível d'água e umidade do solo), realiza a persistência segura em banco de dados H2 em memória, calcula tendências preditivas através de algoritmos de média móvel e emite alertas automáticos quando os limiares críticos de segurança são ultrapassados.

## 🏛️ Padrões de Projeto Aplicados (Design Patterns)
* **Singleton (`ConfiguracaoSistema`):** Responsável por gerenciar de forma centralizada e global os limiares críticos de alerta e as configurações do território.
* **Factory (`FabricaPrevisao`):** Utilizado para instanciar dinamicamente diferentes estratégias de cálculo preditivo com base na necessidade do sistema.
* **Builder (`RelatorioBuilder`):** Empregado na montagem fluida e estruturada de relatórios analíticos do monitoramento.
* **Herança e Polimorfismo (`ComponenteTerritorial` e `Sensor`):** Organização hierárquica das entidades territoriais e contratos padronizados para o funcionamento de múltiplos tipos de sensores.

---

## 🔍 Reflexão Crítica
O desenvolvimento desta Global Solution permitiu consolidar na prática os fundamentos de Orientação a Objetos (encapsulamento, herança, polimorfismo e abstração) integrados com um ecossistema corporativo real utilizando Spring Boot e JPA. A separação clara de responsabilidades em camadas (Domínio, Repositório e Serviço), somada ao tratamento robusto de exceções customizadas para dados inválidos, garantiu a estabilidade da aplicação, a facilidade de manutenção e a confiabilidade dos dados processados e armazenados.

---

## 🤖 Declaração de Uso de Inteligência Artificial
Declaramos que ferramentas de Inteligência Artificial foram utilizadas como suporte colaborativo e consultivo durante o processo de estruturação lógica, suporte à configuração do ambiente de desenvolvimento no VS Code, resolução de erros e refinamento da documentação arquitetural deste projeto. Toda a validação conceitual, testes práticos e montagem final da aplicação foram revisados e compreendidos integralmente pela equipe.
package com.citizen.territory_predictive_insights;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.citizen.territory_predictive_insights.dominio.Sensor;
import com.citizen.territory_predictive_insights.dominio.SensorPluviometro;
import com.citizen.territory_predictive_insights.excecao.DadosInvalidosException;
import com.citizen.territory_predictive_insights.servico.ConfiguracaoSistema;
import com.citizen.territory_predictive_insights.servico.ServicoMonitoramento;

@SpringBootApplication
public class TerritoryPredictiveInsightsApplication implements CommandLineRunner {

    private final ServicoMonitoramento servicoMonitoramento;

    public TerritoryPredictiveInsightsApplication(ServicoMonitoramento servicoMonitoramento) {
        this.servicoMonitoramento = servicoMonitoramento;
    }

    public static void main(String[] args) {
        SpringApplication.run(TerritoryPredictiveInsightsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        Sensor sensor = new SensorPluviometro("S_01");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- CITIZENTECH: TERRITORY PREDICTIVE INSIGHTS ---");
            System.out.println("1. Simular e Registrar Leitura de Sensor");
            System.out.println("2. Ver Histórico de Medições (S_01)");
            System.out.println("3. Ver Alertas Emitidos");
            System.out.println("4. Atualizar Limiares do Território");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                if (!scanner.hasNextInt()) {
                    System.out.println("[ERRO]: Digite um número válido do menu.");
                    scanner.next();
                    continue;
                }
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        try {
                            servicoMonitoramento.processarLeituraSensor(sensor);
                            System.out.println("[SUCESSO] Leitura efetuada, validada e gravada no banco!");
                        } catch (DadosInvalidosException e) {
                            System.out.println("[ERRO DE VALIDAÇÃO]: " + e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("\n--- HISTÓRICO DE MEDIÇÕES (S_01) ---");
                        var historico = servicoMonitoramento.obterHistorico("S_01");
                        if (historico.isEmpty()) {
                            System.out.println("Nenhuma medição registrada ainda. Use a opção 1 primeiro.");
                        } else {
                            historico.forEach(m ->
                                System.out.println("Data: " + m.getDataHora() + " | Tipo: " + m.getTipoSensor() + " | Valor: " + String.format("%.2f", m.getValor()) + " mm")
                            );
                        }
                        break;
                    case 3:
                        System.out.println("\n--- ALERTAS EMITIDOS ---");
                        var alertas = servicoMonitoramento.listarAlertas();
                        if (alertas.isEmpty()) {
                            System.out.println("Nenhum alerta emitido até o momento.");
                        } else {
                            alertas.forEach(a ->
                                System.out.println("Nível: " + a.getNivel() + " | Previsto: " + String.format("%.2f", a.getValorPrevisto()) + " | Motivo: " + a.getMotivo())
                            );
                        }
                        break;
                    case 4:
                        System.out.print("Digite o código de acesso (ADMIN2026): ");
                        String cod = scanner.nextLine();
                        System.out.print("Digite o novo limiar de chuva: ");
                        if (scanner.hasNextDouble()) {
                            double novoLim = scanner.nextDouble();
                            scanner.nextLine();
                            ConfiguracaoSistema.getInstancia().setLimiarCriticoChuva(novoLim);
                            System.out.println("[SUCESSO] Limiar atualizado com sucesso.");
                        } else {
                            System.out.println("[ERRO]: Valor inválido para o limiar.");
                            scanner.next();
                        }
                        break;
                    case 0:
                        System.out.println("Encerrando sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("[ERRO NO SISTEMA]: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
package com.citizen.territory_predictive_insights.servico;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.citizen.territory_predictive_insights.dominio.Alerta;
import com.citizen.territory_predictive_insights.dominio.EstrategiaPrevisao;
import com.citizen.territory_predictive_insights.dominio.Medicao;
import com.citizen.territory_predictive_insights.dominio.NivelAlerta;
import com.citizen.territory_predictive_insights.dominio.Sensor;
import com.citizen.territory_predictive_insights.excecao.DadosInvalidosException;
import com.citizen.territory_predictive_insights.persistencia.AlertaRepository;
import com.citizen.territory_predictive_insights.persistencia.MedicaoRepository;

@Service
public class ServicoMonitoramento {
    private final MedicaoRepository medicaoRepository;
    private final AlertaRepository alertaRepository;

    public ServicoMonitoramento(MedicaoRepository medicaoRepository, AlertaRepository alertaRepository) {
        this.medicaoRepository = medicaoRepository;
        this.alertaRepository = alertaRepository;
    }

    public Medicao processarLeituraSensor(Sensor sensor) throws DadosInvalidosException {
        double valor = sensor.lerValor();
        Medicao medicao = new Medicao("S_01", sensor.retornarTipo(), valor, LocalDateTime.now());
        medicaoRepository.save(medicao);
        avaliarAlerta(medicao);
        return medicao;
    }

    private void avaliarAlerta(Medicao medicao) {
        List<Medicao> historico = medicaoRepository.findBySensorId(medicao.getSensorId());
        EstrategiaPrevisao estrategia = FabricaPrevisao.criarEstrategia("MEDIA");
        double previsto = estrategia.prever(historico);

        double limiar = ConfiguracaoSistema.getInstancia().getLimiarCriticoChuva();

        if (previsto >= limiar) {
            NivelAlerta nivel = previsto > (limiar * 1.2) ? NivelAlerta.CRITICO : NivelAlerta.ALERTA;
            Alerta alerta = new Alerta(
                medicao.getSensorId(),
                previsto,
                limiar,
                nivel,
                "Previsão de precipitação excedeu o limiar de segurança.",
                LocalDateTime.now()
            );
            alertaRepository.save(alerta);
        }
    }

    public List<Medicao> obterHistorico(String sensorId) {
        return medicaoRepository.findBySensorId(sensorId);
    }

    public List<Alerta> listarAlertas() {
        return alertaRepository.findAll();
    }
}
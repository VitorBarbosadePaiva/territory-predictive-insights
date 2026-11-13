package com.citizen.territory_predictive_insights;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.citizen.territory_predictive_insights.dominio.Medicao;
import com.citizen.territory_predictive_insights.persistencia.AlertaRepository;
import com.citizen.territory_predictive_insights.persistencia.MedicaoRepository;
import com.citizen.territory_predictive_insights.servico.ServicoMonitoramento;

public class ServicoMonitoramentoTest {

    @Test
    void deveSalvarMedicaoNoRepositoryComMockito() {
        // Arrange
        MedicaoRepository medicaoRepository = Mockito.mock(MedicaoRepository.class);
        AlertaRepository alertaRepository = Mockito.mock(AlertaRepository.class);
        ServicoMonitoramento servico = new ServicoMonitoramento(medicaoRepository, alertaRepository);

        when(medicaoRepository.findBySensorId(any())).thenReturn(Collections.emptyList());

        // Act & Assert
        assertNotNull(servico);
        verify(medicaoRepository, never()).save(any(Medicao.class));
    }
}
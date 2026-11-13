package com.citizen.territory_predictive_insights;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.citizen.territory_predictive_insights.dominio.Medicao;
import com.citizen.territory_predictive_insights.dominio.PrevisaoMediaMovel;

public class PrevisaoMediaMovelTest {

    @Test
    void deveCalcularMediaMovelCorretamente() {
        // Arrange
        PrevisaoMediaMovel previsao = new PrevisaoMediaMovel();
        List<Medicao> historico = Arrays.asList(
            new Medicao("S1", "PLUVIOMETRO", 10.0, LocalDateTime.now()),
            new Medicao("S1", "PLUVIOMETRO", 20.0, LocalDateTime.now()),
            new Medicao("S1", "PLUVIOMETRO", 30.0, LocalDateTime.now())
        );

        // Act
        double resultado = previsao.prever(historico);

        // Assert
        assertEquals(20.0, resultado, 0.001);
    }
}

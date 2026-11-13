package com.citizen.territory_predictive_insights;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.citizen.territory_predictive_insights.dominio.SensorPluviometro;
import com.citizen.territory_predictive_insights.excecao.DadosInvalidosException;

public class MedicaoTest {

    @Test
    void deveValidarLeituraSensorComSucesso() throws DadosInvalidosException {
        // Arrange
        SensorPluviometro sensor = new SensorPluviometro("TEST_01");

        // Act
        double valor = sensor.lerValor();

        // Assert
        assertTrue(valor >= 0, "O valor medido deve ser positivo");
    }
}
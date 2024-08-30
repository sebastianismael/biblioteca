package es.innoit.domain.usecases;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ShipmentCostCalculatorTest {

    @Disabled
    @Test
    public void shouldThrowErrorIfNotExistProducts(){

        assertThrows(Exception.class, () -> {
            ShipmentCostCalculator shipmentCostCalculator = new ShipmentCostCalculator();
            shipmentCostCalculator.calculate(new HashMap<>(), "");
        });
    }

    // TODO agregar tests
}

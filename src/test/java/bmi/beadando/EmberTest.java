package bmi.beadando;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmberTest {

    private static Ferfiak ferfiak = null;
    private UnitTestCounter counter = null;
    private static int count = 0;

    @BeforeEach
    void setUp() {
        double suly = 75;
        double magassag = 180;
        Nok no = new Nok(suly, magassag, "Nő");
        counter = new UnitTestCounter();
    }

    @AfterEach
    void tearDown() throws IOException {
        counter.setPassed(count);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("test_results.json"), counter);
    }

    @Test
    @DisplayName("Ember Normális testsúly")
    void Should_CalculateBMI_When_CorrectParametersUsed() throws Exception {
        //Arrange
        double suly = 75;
        double magassag = 180;
        Nok no1 = new Nok(suly, magassag, "Nő");

        //Act
        double expectedBehaviour = no1.calculateBMI(suly, magassag);

        //Assert
        assertEquals(expectedBehaviour, 23.148148148148145);

        EmberTest.count++;
    }

    @Test
    @DisplayName("Ember Normális testsúly szövegesen")
    void Should_GetBMIcategory_When_CorrectParametersUsed() throws Exception {
        //Arrange
        double suly = 75;
        double magassag = 180;
        Nok no1 = new Nok(suly, magassag, "Nő");

        //Act
        String expectedBehaviour = no1.getBMICategory(suly, magassag);

        //Assert
        assertEquals(expectedBehaviour, "Normális testsúly");

        EmberTest.count++;
    }

    @Test
    @DisplayName("Testúly negatív")
    void Should_GetBMICategory_When_NegativeWeightUsed() throws Exception {
        //Arrange
        double suly = -10;
        double magassag = 180;
        Nok no1 = new Nok(suly, magassag, "Nő");

        //Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            no1.getBMICategory(suly, magassag);
        });

        EmberTest.count++;
    }

    @Test
    @DisplayName("Testúly negatív")
    void Should_GetBMICategory_When_NullWeightUsed() throws IllegalArgumentException {
        //Arrange
        double suly = 0;
        double magassag = 180;
        Nok no1 = new Nok(suly, magassag, "Nő");

        //Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            no1.getBMICategory(suly, magassag);
        });

        EmberTest.count++;
    }

    @Test
    @DisplayName("Magasság nulla")
    void Should_GetBMICategory_When_NullHeightUsed() {
        //Arrange
        double suly = 75;
        double magassag = 0;
        Nok no1 = new Nok(suly, magassag, "Nő");

        //Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            no1.getBMICategory(suly, magassag);
        });

        EmberTest.count++;
    }
}

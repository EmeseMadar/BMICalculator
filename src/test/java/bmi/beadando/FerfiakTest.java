package bmi.beadando;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FerfiakTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Férfi normál magasság szövegesen")
    void Should_Calculate_getHeightCategory_When_AverageExpected() {
        //Arrange
        double suly = 75;
        double magassag = 179;
        Ferfiak Ferfi1 = new Ferfiak(suly, magassag, "Férfi");

        //Act
        String expectedBehaviour = Ferfi1.getHeightCategory(magassag);
        String actualBehaviour = "átlagos";

        //Assert
        assertEquals(expectedBehaviour, actualBehaviour);
    }

    @Test
    @DisplayName("Férfi magas magasság szövegesen")
    void Should_Calculate_getHeightCategory_When_TallExpected() {
        //Arrange
        double suly = 75;
        double magassag = 180;
        Ferfiak Ferfi1 = new Ferfiak(suly, magassag, "Férfi");

        //Act
        String expectedBehaviour = Ferfi1.getHeightCategory(magassag);
        String actualBehaviour = "magas";

        //Assert
        assertEquals(expectedBehaviour, actualBehaviour);
    }

    @Test
    @DisplayName("Férfi alacsony magasság szövegesen")
    void Should_Calculate_getHeightCategory_When_ShortExpected() {
        //Arrange
        double suly = 75;
        double magassag = 164;
        Ferfiak Ferfi1 = new Ferfiak(suly, magassag, "Férfi");

        //Act
        String expectedBehaviour = Ferfi1.getHeightCategory(magassag);
        String actualBehaviour = "alacsony";

        //Assert
        assertEquals(expectedBehaviour, actualBehaviour);
    }

    @Test
    @DisplayName("Férfi 0 magasság szövegesen")
    void Should_Calculate_getHeightCategory_When_NullHeightUsed() throws IllegalArgumentException {
        //Arrange
        double suly = 75;
        double magassag = 0;
        Ferfiak ferfi1 = new Ferfiak(suly, magassag, "Férfi");

        //Act & Assert

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ferfi1.getBMICategory(suly, magassag);
        });
    }

    @Test
    @DisplayName("Férfi 0 magasság szövegesen")
    void Should_Calculate_getHeightCategory_When_NegativeHeightUsed() throws IllegalArgumentException {
        //Arrange
        double suly = 75;
        double magassag = -10;
        Ferfiak ferfi1 = new Ferfiak(suly, magassag, "Férfi");

        //Act & Assert

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ferfi1.getBMICategory(suly, magassag);
        });
    }
}

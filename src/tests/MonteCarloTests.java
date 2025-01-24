package tests;

import model.MonteCarlo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;





public class MonteCarloTests {
    MonteCarlo mcTest;

    @BeforeEach
    public void setup() {
        mcTest = new MonteCarlo("TEST", 50.0, 10, 100, 0.1, 1, 0.1);
    }

    @Test
    public void constructorTest () {
        assertEquals("TEST", mcTest.ticker);
        assertEquals(10, mcTest.getSimCount());
    }

    

    

}


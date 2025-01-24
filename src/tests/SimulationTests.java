package tests;

import model.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationTests {
    Simulation testSim;

    @BeforeEach
    public void setup() {
        testSim = new Simulation(100, 0.1, 1, 50, 0.1);
    }

    @Test 
    public void constructorTest() {
        assertEquals(0.1, testSim.getDrift());
        assertEquals(100, testSim.getPath().length);
    }
    

    


}

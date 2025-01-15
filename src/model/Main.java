package model;



public class Main {
    public static void main(String[] args) throws Exception {
        MonteCarlo mc1 = new MonteCarlo("APPL", 397.0, 100, 100, 0.1, 10, 0.3);
        Simulation test = mc1.simulations[1];
        test.runSim();
        test.displayPath();
    }
}

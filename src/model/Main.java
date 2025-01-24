package model;



public class Main {
    public static void main(String[] args) throws Exception {
        MonteCarlo mc1 = new MonteCarlo("GOOGL", 189.66, 10, 10, 0.1, 1, 0.5);
        mc1.runAll();
        mc1.simulations[1].displayPath();
        mc1.simulations[3].displayPath();
        mc1.simulations[9].displayPath();
        //Simulation test = mc1.simulations[1];
        //test.runSim();
       // test.displayPath();
    } 
}

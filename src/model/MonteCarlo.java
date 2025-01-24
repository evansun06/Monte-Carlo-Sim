package model;

import java.lang.reflect.Array;

public class MonteCarlo {

    public String ticker;
    public Simulation[] simulations;

    private Double currentPrice;
    private int simCount; //#of  sims

    



    public MonteCarlo(String ticker, Double init, int simSize, int steps, double drift, double timeHorizon, double vol) {//custom object init
        //set object field
        this.ticker = ticker;
        currentPrice = init;
        simCount = simSize;
        //initiate Simulation Array (columns)
        simulations = new Simulation[simSize];

        //fill each index of [simulations] with a simulation object
        for (int x = 0; x < simSize; x++) {
            simulations[x] = new Simulation(steps, drift, timeHorizon, init, vol);
        }
    }
    
    //run all simulations
    public void runAll() {
        for (int x = 0; x < simCount; x++) {
            simulations[x].runSim();
        }
    }

    //getter
    public int getSimCount() {
        return this.simCount;
    }



}

package model;

import java.util.Arrays;
import java.util.Random;

public class Simulation {

    
    private static double mu; //drift coefficient
    private static  int n; //n steps 
    private static double overall; //overall timeframe
    private static double vol; //volitility %

    private double[] path; //path of single Brownian simulation
    private double s_0; //initial stock price
    private double s; // stepped stock price
    

    //constructor for Simulation object.
    public Simulation (int steps, double drift, double overall_t, double initPrice, double volitility) {
        this.path = new double[steps]; 
        this.s_0 = initPrice;

        n = steps;
        overall = overall_t;
        setVol(volitility);
        setDrift(drift);
    }

    //geometric brownian motion
    public void runSim () {
        Random random = new Random();
        double dt = overall/((double)n);
        double sqrtdt = Math.sqrt(dt);
        path[0] = s_0;

        for (int t = 1; t < n; t++){
            double dz = random.nextGaussian(); //stochastic randomness
            path[t] = path[t-1] * Math.exp((mu-(vol*vol)/2)*dt + (vol * sqrtdt * dz));

        }

    }

    //setters.
    public static void setVol(double volitility) {
        if (vol < 0){
            throw new IllegalArgumentException("Volatility can not be negative");
        } else {
            vol = volitility;
        }
    }

    public static void setDrift (double drift) {
        if (drift > 1 || drift < -1) {
            throw new IllegalArgumentException("Extreme Drift Constant");
        } else {
            mu = drift;
        }
    }

    //getters.
    public double[] getPath() {
        return path;
    }

    public double getDrift() {
        return mu;
    }

    public double getVol(){
        return vol;
    }

    public double getOverallTime() {
        return overall;
    }

    public double getSteps() {
        return n;
    }

    //debug tools

    public void displayPath() {
         System.out.println(Arrays.toString(path));
    }


}

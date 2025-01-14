package model;
public class Simulation {

    private double[] path; //path of single Brownian simulation
    private double mu; //drift coefficient
    private int n; //n steps 
    private double overall; //overall timeframe
    private double s_0; //initial stock price
    private double s; // stepped stock price
    private double vol; //volitility %


    //constructor for Simulation object.
    public Simulation (int steps, double drift, double overall_t, double s_0, double volitility) {
        this.path = new double[steps];
        this.n = steps;
        this.mu = drift;
        this.overall = overall_t;
        this.s_0 = s_0;
        this.vol = volitility;
    }

    //getters.
    public double[] getPath() {
        return path;
    }

    public double getDrift() {
        return mu;
    }

    public double vol(){
        return vol;
    }


}

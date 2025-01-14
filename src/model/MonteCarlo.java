package model;
public class MonteCarlo {

    String ticker;
    Double S0; //initial stock price
    int simCount; //#of montecarlo sims



    public MonteCarlo(String tick, Double init, int simcount) {//custom object init
        ticker = tick;
        S0 = init;
        simCount = simcount;
    }

    public MonteCarlo(){ //auto object init
        ticker = "";
        S0 = 0.0;
        simCount = 100;
    }

   /*
   public int[] SimsInit(){
        return([1, 3]);
    }
    */ 
}

package model;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

    private Simulation[] data;
    private String filePath;
    

    public CSVWriter (Simulation[] data, String filePath){
        this.filePath = filePath;
        this.data = data;
    }

    public static void main(String[] args) {
        MonteCarlo mc1 = new MonteCarlo("GOOGL", 189.66, 300, 500, 0.1, 1, 0.5);
        mc1.runAll();
        CSVWriter testWriter = new CSVWriter(mc1.simulations,"src/data/test.csv");
        CSVWriter.simulationsToCSV(mc1.simulations);
        mc1.simulations[0].displayPath();
        

    }
    
    //test playground
    public static void testCSV(){
        try (FileWriter writer = new FileWriter("src/data/test.csv", false)){
            writer.write("");
        } catch (IOException e){
            System.err.println(e);
        }
    }
    //method that sends simulation array into a csv file
    private static void simulationsToCSV(Simulation[]sims){
        int rowLength = sims.length;
        int columnLength = sims[0].getPath().length;
        double t = sims[0].getOverallTime();
        double dt = t/((double)sims[0].getSteps());

        try (FileWriter writer = new FileWriter("data/test.csv", false)){
            //Write Column Names
            writer.write("time,");
            for (int x = 1; x <= rowLength; x++) {
                if(x != rowLength){
                    writer.write("sim_" + x + ",");
                } else {
                    writer.write("sim_" + x);
                }
            }
            writer.write(System.lineSeparator());
            //Write Sims by row
            for (int y = 0; y < columnLength; y++){
                //Write Time 
                writer.write(String.format("%.4f",(dt*(double)y))+ ",");
                //Write Stock Price
                for (int x = 0; x < rowLength; x++ ){
                    String formatted = String.format("%.2f",sims[x].getPath()[y]);
                    if (x != (rowLength-1)){
                        writer.write(formatted + ",");
                    } else {
                        writer.write(formatted);
                    }
                }
                writer.write(System.lineSeparator());
            }
        } catch (IOException e){
            System.err.println(e);
        }

         
    }
}


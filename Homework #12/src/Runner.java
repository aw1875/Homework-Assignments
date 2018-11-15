import java.io.*;
import java.util.*;

public class Runner extends Thread {

    private int speed;
    private int rest;
    private String name;
    private int distance;
    private int travelled;

    /**
     * Will take in values to create Runner and set corresponding values
     * @param speed - integer representing the speed of the runner
     * @param rest - integer representing the period of time a runner must rest
     * @param name - string name of the runner
     * @param distance - integer distance of the race to run
     */
    public Runner(int speed, int rest, String name, int distance) {
        this.speed = speed;
        this.rest = rest;
        this.name = name;
        this.distance = distance;
        this.travelled = 0;
    }


    /**
     * Will simulate the runner running the race
     */
    @Override
    public void run() {
        // Create time
        int time = 0;

        // Display that the runner has started
        System.out.println(this.name + " has started the race...");

        // While the runner has not completed the race, simulate it
        while (true) {
            try {
                Thread.sleep(1000);
                time++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ((time % this.rest) == 0) {
                this.travelled += this.speed;
                System.out.println(this.name + ": " + this.travelled + "/" + this.distance);
            }

            if (this.travelled >= this.distance) {
                System.out.println(this.name + " has finished the race...");
                break;
            }
        }

    }

    /**
     * Will obtain file name from command line, read the file and create Runner threads, start all the threads once they're all created, wait for them all to finish once they have started
     * @param args - command line arguments
     */
    public static void main (String [] args) {
        String file_name = "src/t1.txt";

        // Read in file and create Runner threads
        try {
            BufferedReader b1 = new BufferedReader(new FileReader(file_name));
            String input;
            ArrayList<Runner> runners = new ArrayList<>();

            // Create runner and add to runners list
            while ((input = b1.readLine()) != null) {
                String currLine[] = input.split(",");
                Runner runner = new Runner(Integer.parseInt(currLine[1].trim()), Integer.parseInt(currLine[2].trim()), currLine[0].trim(), 1000);
                runners.add(runner);
            }

            // Start each thread
            for (Runner runner : runners) {
                runner.start();
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

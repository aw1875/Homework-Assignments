public class Runner extends Thread {

    private int speed;
    private int rest;
    private String name;
    private int distance;

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
    }

    /**
     * Will simulate the runner running the race
     */
    @Override
    public void run() {
        super.run();
    }

    /**
     * Will obtain file name from command line, read and create Runner threads, start all the threads once they're all created, wait for them all to finish once they have started
     * @param args - command line arguments
     */
    public static void main (String [] args) {
        String file_name = args[0];

    }
}

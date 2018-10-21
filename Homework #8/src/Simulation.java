import edu.rit.cs.graph.Node;

import java.io.*;

/**
 * file: Simulation.java
 * language: java
 * author: Adam Wolf
 */

public class Simulation {
    /**
     * Read first input from args as the graph, the second as the commands.
     * Create a new graph g1.
     * While the graph input is not null (has not reached the end of the file) split it and check if the node exists.
     * If it doesn't exist create a new one
     * While the commands input is not null (has not reached the end of the file) split it and process the first word to get proper command.
     * If command is quit, break the loop.
     * If command is Add, check if the node exists and if not create it.
     * If command is AddNeighbor, check if the node exists and if not create it and add the neighbor to it. If it does add neighbor to it.
     * If command is HasNode, check if node exists and print true or false accordingly.
     * If command is HasNeighbor, check if neighbor is in given node and print true or false accordingly.
     * If command is PrintNeighbors, print out neighbors of given node.
     * If command is PrintGraph, print the graph using toString.
     *
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader f1;
        BufferedReader f2;
        String filename = args[0];
        String commands = args[1];
        ArrayGraph g1 = new ArrayGraph();
        try {
            f1 = new BufferedReader(new FileReader(filename));
            String input;
            while ((input = f1.readLine()) != null) {
                String[] currLine = input.split(" ");
                if (!g1.hasNode(currLine[0])) {
                    g1.makeNode(currLine[0]);
                }
//                if (!g1.getNeighbors(g1.getNode(currLine[0])).contains(currLine[1]))
//                {
//                    g1.addNeighbor(g1.getNode(currLine[0]), g1.makeNode(currLine[1]));
//                }
            }
            f1.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        try {
            f2 = new BufferedReader(new FileReader(commands));
            String input;
            while ((input = f2.readLine()) != null) {
                String[] currLine = input.split(" ");
                switch (currLine[0]) {
                    case "Quit":
                        break;
                    case "Add":
                        if (!g1.hasNode(currLine[1])) {
                            g1.makeNode(currLine[1]);
                        }
                        break;
                    case "AddNeighbor":
                        if (!g1.hasNode(currLine[1])) {
                            g1.addNeighbor(g1.makeNode(currLine[1]), g1.makeNode(currLine[2]));
                        } else {
                            g1.addNeighbor(g1.getNode(currLine[1]), g1.makeNode(currLine[2]));
                        }
                        break;
                    case "HasNode":
                        if (!g1.hasNode(currLine[1])) {
                            System.out.println("False");
                        } else {
                            System.out.println("True");
                        }
                        break;
                    case "HasNeighbor":
                        // Won't work due to errors I have with getNeighbors
                        if (!g1.getNeighbors(g1.getNode(currLine[1])).contains(currLine[2])) {
                            System.out.println("False");
                        } else {
                            System.out.println("True");
                        }
                        break;
                    case "PrintNeighbors":
                        // Won't work due to errors I have with getNeighbors
                        g1.getNeighbors(g1.getNode(currLine[1])).toString();
                        break;
                    case "PrintGraph":
                        g1.toString();
                        break;
                }
            }
            f2.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

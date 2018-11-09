import java.util.*;
import java.io.*;

public class ShortestDistance {

    Map<String, Node> graph = new HashMap<>();

    /**
     * Take in file and construct graph
     *
     * @param filename - file containing graph info
     */
    public ShortestDistance(String filename) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            String input;

            while ((input = bf.readLine()) != null) {
                String currLine[] = input.split(",");
                Node currNode = new Node(currLine[0].trim());
                if (!graph.containsKey(currLine[0].trim())) {
                    currNode.addNeighbor(new Node(currLine[1].trim()), Integer.parseInt(currLine[3].trim()));
                    graph.put(currLine[0].trim(), currNode);
                } else {
                    graph.get(currLine[0]).addNeighbor(new Node(currLine[1].trim()), Integer.parseInt(currLine[3].trim()));
                }
                Node secondaryNode = new Node(currLine[1].trim());
                if (!graph.containsKey(currLine[1].trim())) {
                    graph.put(currLine[1].trim(), secondaryNode);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }


    /**
     * Will return graph constructed
     *
     * @return constructed graph
     */
    public Map<String, Node> getGraph() {
        return graph;
    }

    /**
     * Will print the graph
     *
     * @return result - the graph as a string
     */
    public String toString() {
        String result = "";
        for (String i : graph.keySet()) {
            result += graph.get(i);
            result += "\n";
        }
        return result;
    }

    /**
     * Get arguments from command line, construct graph, print graph, and perform Dijkstra's algorithm for shortest distance
     *
     * @param args - command line arguements
     */
    public static void main(String[] args) {
        ShortestDistance sd = new ShortestDistance(args[0]);
        System.out.println(sd.toString());
        Graph.displayShortestPath(sd.getGraph(), args[1], args[2]);
    }
}

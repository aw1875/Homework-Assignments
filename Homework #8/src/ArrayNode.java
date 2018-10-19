import edu.rit.cs.graph.Node;

import java.util.ArrayList;

public class ArrayNode implements Node {
    private String name;
    private ArrayList<ArrayNode> neighbors;

    public ArrayNode(String name, ArrayList<ArrayNode> neighbors) {
        this.name = name;
        this.neighbors = neighbors;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<ArrayNode> neighbors() {
        return this.neighbors;
    }

    public void addNeighbors(ArrayNode n) {
        boolean inArray = false;
        for (n:
             neighbors) {
            if (n.equals(neighbors)) {
                inArray = true;
            }

            if (inArray != true) {
                neighbors.add(n);
            }
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < neighbors.size(); i++) {
            result += neighbors.get(i) + " ";
        }
        return this.name + result;
    }
}

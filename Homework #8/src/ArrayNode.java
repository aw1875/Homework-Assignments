import edu.rit.cs.graph.Node;

import java.util.*;

/**
 * file: ArrayNode.java
 * language: java
 * author: Adam Wolf
 */

public class ArrayNode implements Node {
    private String name;
    private ArrayList<ArrayNode> neighbors;

    /**
     * ArrayNode constructor. Set name to given name and set neighbors to new ArrayList.
     * @param name
     */
    public ArrayNode(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    /**
     * Get name of ArrayNode.
     * @return this.name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * IDK
     * @return
     */
    public Set<Node> getNeighbors() {
        //return this.neighbors;
        return null;
    }

    /**
     * Add to neighbors ArrayList.
     * @param n
     */
    public void addNeighbors(ArrayNode n) {
        neighbors.add(n);
    }

    /**
     * Iterate through neighbors ArrayList and add each node to result.
     * @return result.
     */
    public String toString() {
        String result;
        result = this.name + ": ";
        for (Node nbr : neighbors) {
            result = result + this.getName() + ", ";
        }
        // remove last comma and space (just spaces if no nbrs)
        return (result.substring(0, result.length() - 2));

    }
}

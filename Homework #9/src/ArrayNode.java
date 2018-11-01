import edu.rit.cs.graph.Node;

import java.util.ArrayList;
import java.util.Collection;

/**
 * file: ArrayNode.java
 * language: java
 * author: Adam Wolf
 */

public class ArrayNode implements Node {
    private String name;
    private ArrayList<Node> neighbors;

    /**
     * ArrayNode constructor. Set name to given name and set neighbors to new ArrayList.
     *
     * @param name
     */
    public ArrayNode(String name) {
        this.name = name;
        this.neighbors = new ArrayList<Node>();
    }

    /**
     * Get name of ArrayNode.
     *
     * @return this.name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the neighbors of ArrayNode
     *
     * @return ArrayList of neighbors
     */
    public Collection<Node> getNeighbors() {
        return this.neighbors;
    }

    /**
     * Checks if neighbors exits. If it does then do nothing, if not then add the new one.
     *
     * @param n
     */
    public void addNeighbor(ArrayNode n) {
        boolean exists = false;
        for (Node i : neighbors) {
            if (i.equals(n)) {
                exists = true;
            }
        }
        if (!exists) {
            neighbors.add(n);
        }
    }

    /**
     * Iterate through neighbors ArrayList and add each node to result.
     *
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

import edu.rit.cs.graph.Graph;
import edu.rit.cs.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * file: ArrayGraph.java
 * language: java
 * author: Adam Wolf
 */

public class ArrayGraph implements Graph {

    Map<String, Node> graph = new HashMap<>();

    /**
     * ArrayGraph constructor. Create new HashMap graph.
     */
    public ArrayGraph() {
        Map<String, Node> graph = new HashMap<>();
    }

    /**
     * Iterate through graph and add each iteration to result.
     *
     * @return result.
     */
    public String toString() {
        String result = null;
        for (int i = 0; i < graph.size(); i++) {
            result = result + graph.get(i) + "\n";
        }
        return result;
    }

    /**
     * IDK
     *
     * @return
     */
    @Override
    public Iterable<Node> getNodes() {
        return getNodes();
    }

    /**
     * Check if graph contains the key of nodeName.
     *
     * @param nodeName name of a node
     * @return If it does true, if not false.
     */
    @Override
    public boolean hasNode(String nodeName) {
        if (graph.containsKey(nodeName)) {
            return true;
        }
        return false;
    }

    /**
     * If node of nodeName exists, get the node.
     *
     * @param nodeName the sought node's name
     * @return the node of given name if exists, null if not.
     */
    @Override
    public Node getNode(String nodeName) {
        if (hasNode(nodeName)) {
            return graph.get(nodeName);
        }
        return null;
    }

    /**
     * Get name of the node given.
     *
     * @param node the node to look up
     * @return name of given node as string.
     */
    @Override
    public String getNodeName(Node node) {
        ArrayNode test = (ArrayNode) node;
        return test.getName();
    }

    /**
     * Add a new neighbor to given node.
     *
     * @param node     the source node for the edge
     * @param neighbor the destination node for the edge
     */
    @Override
    public void addNeighbor(Node node, Node neighbor) {
        ArrayNode test = (ArrayNode) node;
        ArrayNode test2 = (ArrayNode) neighbor;
        test.addNeighbors(test2);
    }

    /**
     * IDK
     *
     * @param node the node whose neighbors are sought
     * @return
     */
    @Override
    public Set<Node> getNeighbors(Node node) {
        ArrayNode test = (ArrayNode) node;
        return test.getNeighbors();
    }

    /**
     * Create new ArrayNode with given name.
     *
     * @param nodeName the name of the new node
     * @return new node in "graph".
     */
    @Override
    public Node makeNode(String nodeName) {
        ArrayNode newNode = new ArrayNode(nodeName);
        return graph.put(nodeName, newNode);
    }
}

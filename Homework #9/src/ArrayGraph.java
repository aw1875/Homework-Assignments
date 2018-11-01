import edu.rit.cs.graph.Graph;
import edu.rit.cs.graph.Node;

import java.util.*;

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

    @Override
    public Iterable<Node> getNodes() {
        return null;
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
        for (Map.Entry<String, Node> i : graph.entrySet()) {
            String name = i.getKey();
            Node node1 = i.getValue();
            if (node1.equals(node)) {
                return name;
            }
        }
        return "Node not in the graph.";
    }

    @Override
    public void addNeighbor(Node node, Node neighbor) {
        ArrayNode tempNode = (ArrayNode) node;
        ArrayNode tempNeighbor = (ArrayNode) neighbor;
        if(graph.containsValue(node)) {
            tempNode.addNeighbor(tempNeighbor);
        }
    }

    @Override
    public Set<Node> getNeighbors(Node node) {
        ArrayNode tempNode = (ArrayNode) node;
        //return (Set<Node>) tempNode.getNeighbors();
        Set<Node> temp = (Set<Node>) tempNode.getNeighbors();
        return temp;
    }

    @Override
    public Node makeNode(String nodeName) {
        ArrayNode newNode = new ArrayNode(nodeName);
        return newNode;
    }
}

package edu.rit.cs.graph.matrixgraph;

import edu.rit.cs.graph.Node;

/**
 * A convenience class to hold locations in a two-dimensional matrix.
 * Unlike {@link edu.rit.cs.graph.linkedgraph.LinkedNode}, these nodes don't
 * know anything about themselves other than their index in the graph
 * matrix. Therefore they all maintain a link back to their graph in case
 * other information is needed.
 *
 * As stated in {@link AdjMatrix} there are better ways to build an
 * adjacency matrix if a different interface for the graph were designed.
 *
 * @author James Heliotis
 */
public class NodeLoc implements Node {

    /**
     * The position (both row and column) of this node in the graph matrix
     */
    private final int index;

    /**
     * The reference to the node's graph, discussed in the class documentation
     */
    private final AdjMatrix myGraph;

    /**
     * Create a new node.
     * @param graph the graph to which the node belongs
     * @param index the position of the node in the graph's adjacency matrix
     */
    public NodeLoc( AdjMatrix graph, int index ) {
        this.myGraph = graph;
        this.index = index;
    }

    /**
     * Getter for the index
     * @return the position of the node in the graph's adjacency matrix
     */
    int index() {
        return this.index;
    }

    /**
     * Is this node equal to another object?
     * @param o the other object
     * @return true iff o is a NodeLoc, their indices are the same, and
     *         they refer to the same graph
     */
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        try {
            NodeLoc nl2 = (NodeLoc)o;
            return this.index == nl2.index && this.myGraph == nl2.myGraph;
        }
        catch( ClassCastException cce ) {
            return false;
        }
    }

    /**
     * Compute a hash code
     * @return a hash code based on the index
     */
    @Override
    public int hashCode() {
        return Integer.hashCode( this.index );
    }

    /**
     * Create a printable representation of this node
     * @return the string name of this node, as stored in its graph
     */
    @Override
    public String toString() {
        return this.myGraph.getNodeName( this );
    }
}

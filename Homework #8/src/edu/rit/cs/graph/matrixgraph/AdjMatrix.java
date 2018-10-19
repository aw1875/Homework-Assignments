package edu.rit.cs.graph.matrixgraph;

import edu.rit.cs.graph.Graph;
import edu.rit.cs.graph.Node;
import edu.rit.cs.util.Range;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A graph implementation based on the "adjacency matrix" idea.
 * If the graph has n nodes, there is an nxn matrix of booleans.
 * The boolean at location [i,j] is true only if there is an edge
 * from node i to node j. Numbers are assigned to nodes when they
 * are initially added to the graph. Client code can refer to
 * the nodes by their string names.
 *
 * Because there is a different subclass of Node that goes with
 * this graph, some downcasting has to take place when Node objects
 * are passed in as arguments. That means that carelessly coded clients
 * of this class could experience {@link ClassCastException}s.
 *
 * @author James Heliotis
 */
public class AdjMatrix implements Graph {

    /**
     * Resizable arrays are used in this implementation because the number
     * of nodes in the graph is not known a priori. The initial allocation
     * of storage is defined by this constant.
     */
    private static final int DEFAULT_NNODES = 100;

    /**
     * the (current) number of nodes in the graph
     */
    private int size;

    /**
     * This map lets one look up a node by its name. The NodeLoc objects
     * internally contain the numbers mentioned in the class documentation.
     */
    private Map< String, NodeLoc > nameMap;

    /**
     * The boolean matrix that represents the graph's edges
     */
    private ArrayList< ArrayList< Boolean > > graph;

    /**
     * Create an empty graph. There are as yet no nodes and therefore no edges.
     */
    public AdjMatrix() {
        this.nameMap = new HashMap<>();
        this.graph = new ArrayList<>( DEFAULT_NNODES );
                // Remember, the size given to above constructor is CAPACITY.
        this.size = 0;
    }

    /** {@inheritDoc} */
    @Override
    public Iterable< Node > getNodes() {

        Iterator< NodeLoc > underlying = this.nameMap.values().iterator();
        return () -> new Iterator< Node >() {
            @Override
            public boolean hasNext() {
                return underlying.hasNext();
            }

            @Override
            public Node next() {
                return underlying.next();
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNode( String nodeName ) {
        return this.nameMap.containsKey( nodeName );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNode( String nodeName ) {
        return this.nameMap.get( nodeName );
    }

    /**
     * Look up the name of a node.
     * Because of how nodes and their names are associated, this is
     * an inefficient -- O(n) -- operation.
     *
     * {@inheritDoc}
     * @return the node's name, or {@link #UNFOUND_NODE_NAME} if the
     *         node does not exist
     */
    @Override
    public String getNodeName( Node node ) {
        for ( String key: this.nameMap.keySet() ) {
            if ( this.nameMap.get( key ).equals( node ) ) {
                return key;
            }
        }
        return UNFOUND_NODE_NAME;
    }

    /**
     * Add a neighbor to a node in the graph by setting the spot in
     * the adjacency matrix to true.
     * {@inheritDoc}
     */
    @Override
    public void addNeighbor( Node node, Node neighbor ) {
        this.graph
                .get( ((NodeLoc)node).index() )
                .set( ((NodeLoc)neighbor).index(), true );
    }

    /**
     * Fetch all the neighbors of a given node by looking for "true spots"
     * in the appropriate row of the adjacency matrix.
     * {@inheritDoc}
     */
    @Override
    public Set< Node > getNeighbors( Node node ) {
        // The matrix row representing all the neighbors of node
        final int rowNum = ( (NodeLoc)node ).index();
        final ArrayList< Boolean > row = this.graph.get( rowNum );
        // Collect the numbers (indices) of all nodes where there
        // is a true value in this row.
        Collection< NodeLoc > neighbors = IntStream.range( 0, this.size )
                                                   .filter( c -> row.get( c ) )
                                                   .mapToObj( c -> new NodeLoc( this, c ) )
                                                   .collect( Collectors.toList() );
        // Convert the collection to a set, as required.
        HashSet< Node > result = new HashSet<>( neighbors );
        return result;
    }

    /**
     * Make a new node and associate it with a string name.
     * The only change to the adjacency matrix is if the matrix
     * needs to be resized. However, no spots in the matrix
     * associated with this node will be set to true since the
     * new node has no neighbors as yet.
     * {@inheritDoc}
     */
    @Override
    public Node makeNode( String nodeName ) {
        int newIndex = this.size;
        NodeLoc newNode = new NodeLoc( this, newIndex );
        this.nameMap.put( nodeName, newNode );
        this.expandOrInit( newIndex + 1 );
        return newNode;
    }

    /**
     * Resize the array when a new node is added. (This procedure is incredibly
     * inefficient. Normally when one uses an adjacency matrix, the number of
     * nodes is fixed a graph creation time, so a primitive array that never
     * changes size could be used.)
     *
     * @param limit the new number of nodes in the graph
     */
    private void expandOrInit( int limit ) {
        // Extend existing rows.
        final List< Boolean > extension = Collections.nCopies( limit - this.size, false );
        for ( int row: Range.of( this.size ) ) {
            this.graph.get( row ).addAll( extension );
        }
        // Add new rows.
        final List< Boolean > full = Collections.nCopies( limit, false );
        for ( int row: Range.of( this.size, limit ) ) {
            this.graph.add( new ArrayList<>( full ) );
        }
        this.size = limit;
    }

    /**
     * Given a node number for the graph, if that number is outside the known
     * range of node numbers, the matrix gets expanded.
     *
     * @param index the (possibly new) node number
     */
    private void checkResize( int index ) {
        if ( index >= this.size ) {
            expandOrInit( index + 1 );
        }
    }

    /**
     * Generate a string associated with the graph. The string
     * is comprised of one line for each node in the graph, which is
     * unconventionally large for a method overriding the
     * {@link Object#toString()} method.
     * <br>
     * Note that this string is not as informative as the one in
     * {@link edu.rit.cs.graph.linkedgraph.LinkedGraph}.
     *
     * @return string associated with the graph.
     */
    @Override
    public String toString() {
        String result = "";
        for ( String name : this.nameMap.keySet() ) {
            final NodeLoc node = this.nameMap.get( name );
            result = result + node + ':';
            for ( Node neighbor: this.getNeighbors( node ) ) {
                result += ' ' + this.getNodeName( neighbor );
            }
            result += '\n';
        }
        return result;
    }

}

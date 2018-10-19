package edu.rit.cs.graph;

import java.util.Scanner;

/**
 * Demos/tests of the Graph classes.
 * <p>
 * To run adjacency list version:
 * $ java Demo linkedgraph.LinkedGraph
 * <p>
 * To run adjacency matrix version:
 * $ java Demo matrixgraph.AdjMatrix
 *
 * @author James Heliotis
 */
public class Demo {

    private static final String BASE_PACKAGE = "edu.rit.cs.graph.";
    public static final int CMD_LINE_ERROR = 1;
    public static final int INSTANTIATION_ERROR = 2;

    /**
     * Main driver prompts for the name of a graph file, builds the graph,
     * prompts for a start and finish node name, and prints a resulting path.
     *
     * @param args not used unless a Graph implementing class is specified
     * @throws Exception if there is an IO problem with the data files
     *                   or if there is a problem with the named graph class
     */
    public static void main( String[] args ) throws Exception {

        Scanner userInput = new Scanner( System.in );

        String graphImpl = "";
        switch ( args.length ) {
            case 0: // Prompt user for graph implementation class.
                System.out.println( "Provide graph implementation class." );
                System.out.print( BASE_PACKAGE );
                System.out.flush();
                graphImpl = userInput.nextLine();
                break;
            case 1: // Graph implementation class on cmd line
                graphImpl = args[ 0 ];
                break;
            default:
                System.err.println(
                        "Usage: \"java Demo [ graph class ]\"" );
                System.exit( CMD_LINE_ERROR );
        }

        Graph g = GraphFactory.undirectedFromFile(
                "data/internet.txt", BASE_PACKAGE + graphImpl );

        if ( g == null ) {
            System.err.println(
                    "Could not instantiate the class you specified." );
            System.exit( INSTANTIATION_ERROR );
        }
        System.out.println( "Using the implementation in " + graphImpl );
        System.out.println( g );

        // More canned tests with a different graph.
        g = GraphFactory.undirectedFromFile(
                "data/demo.txt", BASE_PACKAGE + graphImpl );
        assert g != null;
        System.out.println( g );

        // Now do some tests of the user's choice.
        System.out.print( "Enter graph data filename: " );
        String filename = userInput.next();

        Graph graph = GraphFactory.undirectedFromFile(
                filename, BASE_PACKAGE + graphImpl );

        System.out.println( graph );

        System.out.print( "Enter node name: " );
        String start = userInput.next();
        if ( !graph.hasNode( start ) ) {
            System.out.println( start + " is not a valid node in the graph." );
            return;
        }
        Node startNode = graph.getNode( start );

        System.out.println(
                "The nodes connected by outgoing edges from " +
                start + ":");
        graph.getNeighbors( startNode ).forEach( n ->
                System.out.print( graph.getNodeName( n ) + " " )
        );
        System.out.println();

        System.out.println(
                "The nodes connected by incoming edges to " +
                start + ":");

        graph.getNodes().forEach( n ->
                  {
                      if ( graph.getNeighbors( n ).contains( startNode ) ) {
                          System.out.print( graph.getNodeName( n ) + " " );
                      }
                  }
        );
        System.out.println();

        userInput.close();
    }

}

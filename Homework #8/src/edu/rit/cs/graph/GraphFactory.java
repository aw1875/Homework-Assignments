package edu.rit.cs.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * A set of utilities for building graphs. Mutliple Graph implementations are
 * supported because the factory methods take in the Graph implementing
 * class's name as a string.
 *
 * @author James Heliotis
 */
public class GraphFactory {

    /**
     * The constructor loads an <em>undirected</em>graph from file.
     * <br>
     * Each line in the input file is assumed to contain the names of
     * two nodes at opposite ends of an undirected edge.
     * The method creates the graph and creates nodes as necessary as well
     * as edges in both directions between the nodes.
     *
     * @param fileName   name of the input graph specification file
     * @param graphClass the name of the class that implements the
     *                   {@link Graph} interface
     * @return the fully initialized graph as an instance of the named class
     * @throws IOException if there is a problem with the graph implementation
     *                     class file or the input file
     */
    public static Graph undirectedFromFile(
            String fileName, String graphClass ) throws IOException {

        // Create empty graph.
        Graph result = GraphFactory.makeEmpty( graphClass );
        if ( result == null ) {
            throw new IOException( "Could not instantiate " + graphClass );
        }

        try (
                BufferedReader in = new BufferedReader(
                        new FileReader( fileName ) )
        ) {
            // Parse each line in the input file.
            String line = in.readLine();
            while ( line != null ) {
                Node n1, n2;

                // Split the line into an array of strings
                // where each string is separated by a space.
                String[] fields = line.split( "\\s+" );

                // Create new nodes as necessary.
                if ( !result.hasNode( fields[ 0 ] ) ) {
                    n1 = result.makeNode( fields[ 0 ] );
                }
                else {
                    n1 = result.getNode( fields[ 0 ] );
                }
                if ( !result.hasNode( fields[ 1 ] ) ) {
                    n2 = result.makeNode( fields[ 1 ] );
                }
                else {
                    n2 = result.getNode( fields[ 1 ] );
                }

                // Create new edges.
                result.addNeighbor( n1, n2 );
                result.addNeighbor( n2, n1 );

                line = in.readLine();
            }
        }
        return result;
    }

    /**
     * Create an empty graph.
     *
     * @param graphClassName the name of a class that implements Graph and
     *                       has a no-argument constructor that creates
     *                       an empty instance of itself
     * @return the created graph
     */
    public static Graph makeEmpty( String graphClassName ) {
        Graph result = null;
        try {
            Class< ? > graphClass = Class.forName( graphClassName );
            Constructor< ? > ctor = graphClass.getConstructor();
            result = (Graph)ctor.newInstance();
        }
        catch( ClassNotFoundException e ) {
            System.err.println( "The class '" + graphClassName +
                                "' could not be found." );
        }
        catch( NoSuchMethodException | IllegalAccessException e ) {
            System.err.println( graphClassName +
                                " doesn't have an accessible default " +
                                "constructor." );
        }
        catch( InstantiationException e ) {
            System.err
                    .println( graphClassName + " could not be instantiated." );
        }
        catch( InvocationTargetException e ) {
            throw new RuntimeException( e ); // ??
        }
        return result;
    }

}

/**
 * file: Node.java
 * language: java
 * author: Adam Wolf
 */

public class Node <T>
{
    private T value;
    private Node next;

    /**
     * Node constructor that sets next to null
     * @param value
     */
    public Node (T value){ next = null; }

    /**
     * Node constructor that sets value of the node to the given value and sets the next node to the given node.
     * @param value
     * @param next
     */
    public Node (T value, Node next)
    {
        this.value = value;
        this.next = next;
    }

    /**
     * Getter function to return the value of any particular node.
     * @return value
     */
    public T getValue () { return value; }

    /**
     * Getter function to get the next node in the linked list.
     * @return next
     */
    public Node getNext () { return next; }

    /**
     * Setter function to set the next parameter for any particular node.
     * @param next
     */
    public void setNext(Node next) { this.next = next; }
}

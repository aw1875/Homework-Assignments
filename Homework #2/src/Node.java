/**
 * file: Node.java
 * language: java
 * author: Adam Wolf
 */

public class Node
{
    private int value;
    private Node next;

    /**
     * Node constructor that sets value of the node to given value.
     * @param value
     */
    public Node (int value)
    {
        this.value = value;
    }

    /**
     * Node constructor that sets value of the node to the given value and sets the next node to the given node.
     * @param value
     * @param next
     */
    public Node (int value, Node next)
    {
        this.value = value;
        this.next = next;
    }

    /**
     * Getter function to return the value of any particular node.
     * @return value
     */
    public Integer getValue () { return value; }

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

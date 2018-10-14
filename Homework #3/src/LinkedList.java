/**
 * file: LinkedList.java
 * language: java
 * author: Adam Wolf
 */

public class LinkedList <T> implements ILinkedList <T>
{
    private Node <T> head;

    public LinkedList () { this.head = null; }

    /**
     * Getter function to get the node head for any particular node.
     * @return
     */
    public Node getHead () { return head; }


    /**
     * Gets the value at the given index and returns it.
     * @param index
     * @return currentNode.getValue()
     */
    public T valueAt (int index)
    {
        Node <T> n1 = head;
        int counter = 0;
        if (index >= size())
        {
            System.out.println("Index higher than size of list");
            return null;
        }
        for (Node <T> currentNode = head; counter <= index; currentNode = currentNode.getNext())
        {
            n1 = currentNode;
            counter++;
        }
        T test = n1.getValue();
        return test;
    }

    /**
     * Gets the node at the given index and returns it.
     * @param index
     * @return currentNode
     */
    public Node nodeAt (int index)
    {
        Node n1 = head;
        if (index >= size())
        {
            System.out.println("Index higher than size of list");
            return null;
        }
        else
        {
            int counter = 0;
            for (Node currentNode = head; counter <= index; currentNode = currentNode.getNext())
            {
                n1 = currentNode;
                counter++;
            }

            return n1;
        }
    }

    /**
     * Counts the nodes in the linked list and returns the size
     * @return result
     */
    public int size ()
{
    int result = 0;
    for (Node n1 = head; n1.getNext() != null; n1 = n1.getNext())
    {
        result++;
    }
    result++;
    return result;
}

    /**
     * Create a new node and insert at the given index in the linked list.
     * @param value
     * @param index
     */
    public void insertAt (T value, int index)
    {
        Node currentNode = head;
        if (index == 0)
        {
            Node newNode = new Node(value, currentNode);
            head = newNode;
        }
        else if (head != null)
        {
            int counter = 0;
            while (counter < index)
            {
                currentNode.getNext();
                counter ++;
            }
            Node newNode = new Node(value, currentNode.getNext());
            currentNode.setNext(newNode);
        }
        else
        {
            System.out.println("Index out of bounds.");
        }
    }

    /**
     * Removes value at index.
     * @param index
     */
    public void removeAt (int index)
    {
        Node n1 = head;
        int counter = 0;
        for (Node <T> currentNode = head; counter < index; currentNode = currentNode.getNext())
        {
            n1 = currentNode;
            counter++;
        }

        n1.setNext(n1.getNext().getNext());
    }

    /**
     * Creates copy of lst and adds it to the end of the lst.
     * @param lst
     */
    public void concat (LinkedList lst)
    {
        Node currentNode = head;
        //LinkedList concatenated = new LinkedList();
        while (currentNode.getNext().getValue() != null)
        {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(lst.getHead());
        while (currentNode.getNext().getValue() != null)
        {
            currentNode = currentNode.getNext();
        }

    }

    /**
     * Create a new linked list and put the values from the given list in reverse order into the new list
     * @return reversed
     */
    public LinkedList reverse()
    {
        LinkedList reversed = new LinkedList();
        int listSize = size() - 1;
        int counter = 0;
        while (counter <= listSize)
        {
            reversed.insertAt(valueAt(counter), 0);
            counter ++;
        }
        return reversed;
    }

}

/**
 * file: LinkedList.java
 * language: java
 * author: Adam Wolf
 */

public class LinkedList
{
    private Node head;

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
    public Integer valueAt (int index)
    {
        Node currentNode = head;
        int counter = 0;
        while (counter != index)
        {
            currentNode = currentNode.getNext();
            counter ++;
        }
        return currentNode.getValue();
    }

    /**
     * Gets the node at the given index and returns it.
     * @param index
     * @return currentNode
     */
    public Node nodeAt (int index)
    {
        Node currentNode = head;
        if (index >= size())
        {
            System.out.println("Index higher than size of list");
            return null;
        }
        else
        {
            int counter = 0;
            while (counter != index)
            {
                currentNode = currentNode.getNext();
                counter ++;
            }

            return currentNode;
        }
    }

    /**
     * Counts the nodes in the linked list and returns the size
     * @return result
     */
    public int size ()
    {
        int result = 0;
        Node currentNode = head;
        if (currentNode.getValue() == null)
        {
            return result;
        }
        else
        {
            while (currentNode.getNext() != null)
            {
                //System.out.println(currentNode.getValue());
                result++;
                currentNode = currentNode.getNext();
            }
            result ++;
        }
        return result;
    }

    /**
     * Create a new node and insert at the given index in the linked list.
     * @param value
     * @param index
     */
    public void insertAt (int value, int index)
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

    public void removeAt (int index)
    {
    }

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
        while (counter != listSize)
        {
            reversed.insertAt(valueAt(counter), 0);
            counter ++;
        }
        reversed.insertAt(valueAt(counter), 0);
        return reversed;
    }

}

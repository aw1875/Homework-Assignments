public interface ILinkedList <T>
{
    public Node getHead();

    public T valueAt(int index);

    public Node nodeAt(int index);

    public int size();

    public void insertAt(T value, int index);

    public void removeAt(int index);

    public void concat(LinkedList lst);

    public LinkedList reverse();
}

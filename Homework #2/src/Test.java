public class Test {
    public static void main (String [] args)
    {
        LinkedList l1 = new LinkedList();
        l1.insertAt(1, 0);
        l1.insertAt(2, 0);
        l1.insertAt(3, 0);
        l1.insertAt(4, 0);
        l1.insertAt(5, 0);

        LinkedList l2 = new LinkedList();
        l2.insertAt(23,0);
        l2.insertAt(56,0);

        System.out.println("getHead(): " + (l1.getHead().getValue() == 5));
        System.out.println("valueAt(): " + (l1.valueAt(3) == l1.nodeAt(3).getValue()));
        System.out.println("nodeAt(): " + (l1.nodeAt(3).getValue() == l1.valueAt(3)));
        System.out.println("size(): " + (l1.size() == 5));
        System.out.println("\n- - R E V E R S E D - -");
        System.out.println(l1.reverse().valueAt(0));
        System.out.println(l1.reverse().valueAt(1));
        System.out.println(l1.reverse().valueAt(2));
        System.out.println(l1.reverse().valueAt(3));
        System.out.println(l1.reverse().valueAt(4));
        l2.concat(l1);
        System.out.println("idk");
    }
}

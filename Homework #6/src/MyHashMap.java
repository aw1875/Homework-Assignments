import java.util.*;

public class MyHashMap<K, V> {
    private ArrayList<Pair<K, V>> table;
    //Pair idk = new Pair(1, "A");

    public MyHashMap(int size) {
        table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(null);
        }
    }

    public static void main (String [] args) {
        MyHashMap test = new MyHashMap(2);



        test.table.forEach(i -> System.out.println(i));
    }

    /*public Collection<K> getKeys() {
        for(Pair i : table) {
            System.out.println(i);
        }
    }*/
}

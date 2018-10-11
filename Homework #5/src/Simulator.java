import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * file: Simulator.java
 * language: java
 * author: Adam Wolf
 */

public class Simulator {
    public static void main(String[] args) {
        /**
         * Natural order treeset.
         */
        TreeSet<Student> natural = new TreeSet<Student>();

        /**
         * GPA order treeset. Set new compareTo using the gpa.
         */
        TreeSet<Student> gpa = new TreeSet<Student>((a, b) -> {
            return Double.valueOf(a.getGpa()).compareTo(b.getGpa());
        });

        /**
         * Number order treeset. Set new compareTo using number.
         */
        TreeSet<Student> number = new TreeSet<Student>((a, b) -> {
            return Integer.valueOf(a.getNumber()).compareTo(b.getNumber());
        });

        /**
         * Hashset.
         */
        HashSet<Student> hashSet = new HashSet<Student>();

        /**
         * Create student 1 and add to all the sets. Output "Adding : " and the student as a string.
         */
        Student s1 = new Student("Scott", "Johnson", "scj", 123, 3.25);
        natural.add(s1);
        gpa.add(s1);
        number.add(s1);
        hashSet.add(s1);
        System.out.println("Adding: " + s1.toString());

        /**
         * Create student 2 and add to all the sets. Output "Adding : " and the student as a string.
         */
        Student s2 = new Student("Jeremy", "Brown", "jsb", 234, 2.95);
        natural.add(s2);
        gpa.add(s2);
        number.add(s2);
        hashSet.add(s2);
        System.out.println("Adding: " + s2.toString());

        /**
         * Create student 3 and add to all the sets. Output "Adding : " and the student as a string.
         */
        Student s3 = new Student("Jansen", "Orfan", "jro", 345, 3.05);
        natural.add(s3);
        gpa.add(s3);
        number.add(s3);
        hashSet.add(s3);
        System.out.println("Adding: " + s3.toString());

        /**
         * Create student 4 and add to all the sets. Output "Adding : " and the student as a string.
         */
        Student s4 = new Student("James", "Johnson", "jjj", 567, 4.0);
        natural.add(s4);
        gpa.add(s4);
        number.add(s4);
        hashSet.add(s4);
        System.out.println("Adding: " + s4.toString());

        /**
         * Create student 5 and add to all the sets. Output "Adding : " and the student as a string.
         */
        Student s5 = new Student("Adam", "Wolf", "awm", 187, 3.5);
        natural.add(s5);
        gpa.add(s5);
        number.add(s5);
        hashSet.add(s5);
        System.out.println("Adding: " + s5.toString());

        /**
         * Iterator for natural treeset.
         */
        Iterator<Student> natIter = natural.iterator();

        /**
         * Iterator for gpa treeset.
         */
        Iterator<Student> gpaIter = gpa.iterator();

        /**
         * Iterator for number treeset.
         */
        Iterator<Student> numIter = number.iterator();

        /**
         * Iterator for hashset.
         */
        Iterator<Student> hshIter = hashSet.iterator();

        /**
         * Set integer i to 0 (starting place). Check to make sure each iterator has a next value and loop through while outputting student in spot i.
         */
        int i = 0;
        while (natIter.hasNext() && gpaIter.hasNext() && numIter.hasNext() && hshIter.hasNext()) {
            System.out.println("\nStudents at slot " + i);

            Student na = natIter.next();
            Student g = gpaIter.next();
            Student nu = numIter.next();
            Student h = hshIter.next();
            System.out.println("Natural: " + na);
            System.out.println("GPA: " + g);
            System.out.println("Number: " + nu);
            System.out.println("Hash: " + h);
            i++;
        }
    }
}

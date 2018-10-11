/**
 * file: Student.java
 * language: java
 * author: Adam Wolf
 */

public class Student implements Comparable<Student> {
    private String first_name;
    private String last_name;
    private String user_name;
    private int number;
    private double gpa;

    /**
     * Student constructor. Set first_name, last_name, user_name, number, and gpa to given values.
     *
     * @param first_name
     * @param last_name
     * @param user_name
     * @param number
     * @param gpa
     */
    public Student(String first_name, String last_name, String user_name, int number, double gpa) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.number = number;
        this.gpa = gpa;
    }

    /**
     * First name getter.
     *
     * @return first_name.
     */
    public String getFirst_name() {
        return this.first_name;
    }

    /**
     * Last name getter.
     *
     * @return last_name.
     */
    public String getLast_name() {
        return this.last_name;
    }

    /**
     * Username getter.
     *
     * @return user_name.
     */
    public String getUser_name() {
        return this.user_name;
    }

    /**
     * Number getter.
     *
     * @return number.
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * GPA getter.
     *
     * @return gpa.
     */
    public double getGpa() {
        return this.gpa;
    }

    /**
     * Put student object into a string. Example: Student 000: Jeremy James, jaj, 4.0.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Student " + number + ": " + first_name + " " + last_name + ", " + user_name + ", " + String.format("%06f", gpa);
    }

    /**
     * Check if two students are the same by comparing their number.
     *
     * @param o
     * @return true if they are the same, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) {
            return false;
        }
        Student st = (Student) (o);
        return this.number == st.number;
    }

    /**
     * Compare 2 students by last name. If last name is the same for both, compare first name.
     *
     * @param o
     * @return 1, 0, or -1 depending on result.
     */
    @Override
    public int compareTo(Student o) {
        if (this.last_name.compareTo(o.last_name) == 0) {
            return this.first_name.compareTo(o.first_name);
        }
        return this.last_name.compareTo(o.last_name);
    }

    /**
     * Create a hashcode by getting a numeric value for each character in username.
     *
     * @return hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        int length = user_name.length() - 1;
        for (int i = 0; i <= length; i++) {
            hash += Character.getNumericValue(user_name.charAt(i));
        }
        return hash;
    }
}

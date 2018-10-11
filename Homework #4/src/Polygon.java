/**
 * file: Polygon.java
 * language: java
 * author: Adam Wolf
 */

public abstract class Polygon {
    private int sides;

    /**
     * Polygon constructor that sets number of sides to number given.
     * @param sides
     */
    public Polygon(int sides) { this.sides = sides; }

    /**
     * Getter function to return how many sides polygon x has.
     * @return number of sides.
     */
    public int getSides() { return this.sides; }

    /**
     * Abstract method declaration for getter function to get perimeter.
     * @return
     */
    public abstract double getPerimeter();

    /**
     * Abstract method declaration for getter function to get area.
     * @return
     */
    public abstract double getArea();

    /**
     * toString method to return number of sides in a string.
     * @return number of sides in a string.
     */
    @Override
    public String toString() {
        return sides + " sided polygon";
    }

    /**
     * Equals method to determine if object o is equal to polygon x.
     * @param o
     * @return true or false.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Polygon)) {
            return false;
        }

        Polygon ob = (Polygon) o;
        return ob.sides == sides;
    }
}

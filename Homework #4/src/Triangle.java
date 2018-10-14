/**
 * file: Triangle.java
 * language: java
 * author: Adam Wolf
 */

public class Triangle extends Polygon {
    private int s1;
    private int s2;
    private int s3;

    /**
     * Triangle constructor that sets number of sides to 3 and each side to given side lengths
     * @param s1
     * @param s2
     * @param s3
     */
    public Triangle(int s1, int s2, int s3) {
        super(3);
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    /**
     * Helper function for EquilateralTriangle.
     * @return side 1 (s1).
     */
    protected int getSide() { return this.s1; }

    /**
     * Getter function that returns perimeter of triangle x by adding up all sides.
     * @return the perimeter.
     */
    @Override
    public double getPerimeter() {
        return s1 + s2 + s3;
    }

    /**
     * Getter function that returns area of triangle x using heron's formula.
     * @return the area.
     */
    @Override
    public double getArea() {
        double s = s1 + s2 + s3;
        s = s/2;
        return Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
    }

    /**
     * toString method to return each side length of the triangle.
     * @return string of all the sides.
     */
    @Override
    public String toString() {
        return "Triangle with sides " + s1 + ", " + s2 + ", " + s3;
    }

    /**
     * Equals method to determine if triangle ob is equal to given triangle.
     * @param o
     * @return true if all sides lengths match, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Triangle)) {
            return false;
        }

        Triangle ob = (Triangle) o;
        return ob.s1 == s1 && ob.s2 == s2 && ob.s3 == s3;
    }
}

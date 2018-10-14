/**
 * file: Rectangle.java
 * language: java
 * author: Adam Wolf
 */

public class Rectangle extends Polygon {
    private int length;
    private int width;

    /**
     * Rectangle constructor that sets number of sides to 4 and length and width to given length and width.
     * @param length
     * @param width
     */
    public Rectangle(int length, int width) {
        super(4);
        this.length = length;
        this.width = width;
    }

    /**
     * Helper function for square.
     * @return length.
     */
    protected int getSide() { return this.length; }

    /**
     * Getter function that returns perimeter of rectangle x with formula 2 * (length + width).
     * @return the perimeter.
     */
    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    /**
     * Getter function that returns area of rectangle x with formula length * width.
     * @return the area.
     */
    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * toString method to return length and width of the rectangle.
     * @return string of length and width of rectangle.
     */
    @Override
    public String toString() {
        return "Rectangle with length of " + length + " and width of " + width;
    }

    /**
     * Equals method to determine if rectangle ob is equal to given rectangle.
     * @param o
     * @return true if both length and width are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) {
            return false;
        }

        Rectangle ob = (Rectangle) o;
        return ob.length == length && ob.width == width;
    }
}

/**
 * file: Circle.java
 * language: java
 * author: Adam Wolf
 */

public class Circle extends Polygon {
    private int radius;

    /**
     * Circle constructor which sets number of sides to 0 and radius to given radius.
     * @param radius
     */
    public Circle(int radius) {
        super(0);
        this.radius = radius;
    }

    /**
     * Getter function that returns radius of circle x.
     * @return radius of circle x.
     */
    public int getRadius() { return this.radius; }

    /**
     * Gets perimeter of given circle with formula 2 * PI * radius.
     * @return the perimeter.
     */
    @Override
    public double getPerimeter() {
        return (2 * 3.14 * radius);
    }

    /**
     * Gets area of given circle with formula PI * radius squared.
     * @return the area.
     */
    @Override
    public double getArea() {
        return (3.14 * Math.pow(radius, 2));
    }

    /**
     * toString method to return the radius of the circle.
     * @return radius of the circle in a string.
     */
    @Override
    public String toString() {
        return "Circle with radius " + radius;
    }

    /**
     * Equals method to determine if circle ob is equal to given circle.
     * @param o
     * @return true if radius is the same for both, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Circle)) {
            return false;
        }

        Circle ob = (Circle) o;
        return ob.radius == radius;
    }
}

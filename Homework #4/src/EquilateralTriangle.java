/**
 * file: EquilateralTriangle.java
 * language: java
 * author: Adam Wolf
 */

public class EquilateralTriangle extends Triangle {

    /**
     * EquilateralTriangle constructor that uses superclass to create triangle with given side length.
     * @param side
     */
    public EquilateralTriangle(int side) { super(side, side, side); }

    /**
     * toString method to return length of triangles sides (all the same).
     * @return string of the side length.
     */
    @Override
    public String toString() {
        return "Equilateral triangle with sides of " + getSide();
    }
}

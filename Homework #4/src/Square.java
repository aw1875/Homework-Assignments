/**
 * file: Square.java
 * language: java
 * author: Adam Wolf
 */

public class Square extends Rectangle {

    /**
     * Square constructor that uses superclass to create square with given side length.
     * @param side
     */
    public Square(int side) { super(side, side); }

    /**
     * toString method to return side length of the square.
     * @return string of side length.
     */
    @Override
    public String toString() {
        return "Square with sides of " + getSide();
    }
}

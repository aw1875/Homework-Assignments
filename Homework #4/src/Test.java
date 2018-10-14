public class Test {
    public static void main (String [] args) {
        Polygon C = new Circle(10);
        Polygon C2 = new Circle(5);
        Polygon T = new Triangle(1,3,3);
        Polygon T2 = new Triangle(1,3,4);
        Polygon ET = new EquilateralTriangle(5);
        Polygon ET2 = new EquilateralTriangle(2);
        Polygon R = new Rectangle(4,2);
        Polygon R2 = new Rectangle(4,3);
        Polygon S = new Square(4);
        Polygon S2 = new Square(3);

        System.out.println(C.toString());
        System.out.println(C.getPerimeter());
        System.out.println(C.getArea());
        System.out.println(C.equals(C2));
        System.out.println("------------------------");
        System.out.println(T.toString());
        System.out.println(T.getPerimeter());
        System.out.println(T.getArea());
        System.out.println(T.equals(T2));
        System.out.println("------------------------");
        System.out.println(ET.toString());
        System.out.println(ET.getPerimeter());
        System.out.println(ET.getArea());
        System.out.println(ET.equals(ET2));
        System.out.println("------------------------");
        System.out.println(R.toString());
        System.out.println(R.getPerimeter());
        System.out.println(R.getArea());
        System.out.println(R.equals(R2));
        System.out.println("------------------------");
        System.out.println(S.toString());
        System.out.println(S.getPerimeter());
        System.out.println(S.getArea());
        System.out.println(S.equals(S2));
        System.out.println("------------------------");

    }
}

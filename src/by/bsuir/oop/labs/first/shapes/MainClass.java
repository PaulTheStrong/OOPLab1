package by.bsuir.oop.labs.first.shapes;

public class MainClass {
    public static void main(String[] args) {
        AbstractShape rectangle = new Rectangle(new Point2D(1, 3), 10, 20);
        AbstractShape circle = new Circle(new Point2D(3, 2), 4);

        System.out.println(rectangle);
        System.out.println(circle);

        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println("Circle area: " + circle.calculateArea());
    }
}

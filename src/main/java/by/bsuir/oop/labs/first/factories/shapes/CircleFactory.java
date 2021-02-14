package by.bsuir.oop.labs.first.factories.shapes;


import by.bsuir.oop.labs.first.shapes.Circle;
import javafx.geometry.Point2D;

public class CircleFactory extends AbstractShapeFactory {

    @Override
    public Circle createShape() {
        return new Circle(new Point2D(0, 0), 0);
    }
}

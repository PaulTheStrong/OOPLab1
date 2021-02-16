package by.bsuir.oop.labs.first.factories.shapes;


import by.bsuir.oop.labs.first.shapes.Circle;
import javafx.geometry.Point2D;

public class CircleFactory extends AbstractShapeFactory {

    @Override
    public Circle createShape(Point2D startPoint) {
        return new Circle(startPoint, 0);
    }
}

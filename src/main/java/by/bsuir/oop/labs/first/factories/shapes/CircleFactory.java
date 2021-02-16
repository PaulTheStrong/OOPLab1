package by.bsuir.oop.labs.first.factories.shapes;


import by.bsuir.oop.labs.first.shapes.Circle;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class CircleFactory extends AbstractShapeFactory {

    @Override
    public Circle createShape(GraphicsContext graphicsContext, Point2D startPoint) {
        return new Circle(graphicsContext, startPoint, 0);
    }
}

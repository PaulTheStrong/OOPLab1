package by.bsuir.oop.labs.core.factories;

import by.bsuir.oop.labs.core.shapes.Rectangle;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class RectangleFactory extends AbstractShapeFactory {

    @Override
    public Rectangle createShape(GraphicsContext graphicsContext, Point2D startPoint) {
        return new Rectangle(graphicsContext, startPoint, 0, 0);
    }
}

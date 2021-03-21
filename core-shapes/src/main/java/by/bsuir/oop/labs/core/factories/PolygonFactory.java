package by.bsuir.oop.labs.core.factories;

import by.bsuir.oop.labs.core.shapes.Polygon;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class PolygonFactory extends AbstractShapeFactory {
    @Override
    public Polygon createShape(GraphicsContext graphicsContext, Point2D startPoint) {
        return new Polygon(graphicsContext, startPoint, startPoint);
    }
}

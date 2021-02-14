package by.bsuir.oop.labs.first.factories.shapes;

import by.bsuir.oop.labs.first.shapes.Polygon;
import javafx.geometry.Point2D;

public class PolygonFactory extends AbstractShapeFactory {
    @Override
    public Polygon createShape() {
        return new Polygon(new Point2D(0, 0), new Point2D(0, 0));
    }
}

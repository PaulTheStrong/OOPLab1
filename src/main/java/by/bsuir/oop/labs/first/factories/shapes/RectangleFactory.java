package by.bsuir.oop.labs.first.factories.shapes;

import by.bsuir.oop.labs.first.shapes.Rectangle;
import javafx.geometry.Point2D;

public class RectangleFactory extends AbstractShapeFactory {

    @Override
    public Rectangle createShape() {
        return new Rectangle(new Point2D(0, 0), 0, 0);
    }
}

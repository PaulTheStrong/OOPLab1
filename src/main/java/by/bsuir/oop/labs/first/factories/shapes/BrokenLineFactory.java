package by.bsuir.oop.labs.first.factories.shapes;

import by.bsuir.oop.labs.first.shapes.BrokenLine;
import javafx.geometry.Point2D;

public class BrokenLineFactory extends AbstractShapeFactory {
    @Override
    public BrokenLine createShape() {
        return new BrokenLine(new Point2D(0, 0), new Point2D(0, 0));
    }
}

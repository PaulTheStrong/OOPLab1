package by.bsuir.oop.labs.first.factories.shapes;

import by.bsuir.oop.labs.first.shapes.Oval;
import javafx.geometry.Point2D;

public class OvalFactory extends AbstractShapeFactory {
    @Override
    public Oval createShape() {
        return new Oval(new Point2D(0, 0), 0, 0);
    }
}

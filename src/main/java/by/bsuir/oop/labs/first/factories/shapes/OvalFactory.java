package by.bsuir.oop.labs.first.factories.shapes;

import by.bsuir.oop.labs.first.shapes.Oval;
import javafx.geometry.Point2D;

public class OvalFactory extends AbstractShapeFactory {
    @Override
    public Oval createShape(Point2D startPoint) {
        return new Oval(startPoint, 0, 0);
    }
}
